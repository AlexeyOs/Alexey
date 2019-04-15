package ru.osetsky.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.osetsky.models.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

@Controller
public class CarAdd extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CarAdd.class);
    private final ValidateService logic = ValidateService.getInstance();
    private static final long serialVersionUID = 1L;

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";

    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    @RequestMapping(value = "/carAdd", method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/CarAdd.jsp").forward(req, resp);

    }

    /**
     */
    @RequestMapping(value = "/carAdd", method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Car car = convertCarFromJson(req);

        if (checkRequestActuallyContainsUploadFile(req, resp)) {
            return;
        }

        ServletFileUpload upload = configuresUploadSettings();
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        car = parseImageFromRequest(upload, uploadPath, req, car);

        logic.addCar(car);
    }

    private ServletFileUpload configuresUploadSettings() {
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        return upload;
    }

    private Car convertCarFromJson(HttpServletRequest req) throws IOException {
        Car car = new Car();
        car.setBrand(req.getHeader("brand"));
        car.setModel(req.getHeader("model"));
        car.setPrice(req.getHeader("price"));
        return car;
    }

    private boolean checkRequestActuallyContainsUploadFile(HttpServletRequest req,
                                                           HttpServletResponse resp) {
        //checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(req)) {
            // if not, we stop here
            PrintWriter writer = null;
            try {
                writer = resp.getWriter();
                writer.println("Error: Form must has enctype=multipart/form-data.");
                writer.flush();
            } catch (Exception e) {
                LOG.error("Checks if the request actually contains upload file" + e);
            }
            return true;
        } else {
            return false;
        }
    }

    private Car parseImageFromRequest(ServletFileUpload upload,
                                      String uploadPath,
                                      HttpServletRequest req,
                                      Car car) {
        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // saves the file on disk
                        item.write(storeFile);
                        // save to JSON
                        byte[] fileContent = Files.readAllBytes(storeFile.toPath());
                        car.setImage(fileContent);
                        InputStream inputStream =  new ByteArrayInputStream(car.getImage());
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }

                        byte[] imageBytes = outputStream.toByteArray();

                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                        inputStream.close();
                        outputStream.close();
                        car.setBase64Image(base64Image);
                        req.setAttribute("message",
                                "Upload has been done successfully!");
                    }
                }
            }
        } catch (Exception ex) {
            req.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        return car;
    }
}
