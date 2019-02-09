package ru.osetsky.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;
import ru.osetsky.models.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.List;

public class FileUploadServlet extends HttpServlet {

    private final ValidateService logic = ValidateService.getInstance();
    private static final long serialVersionUID = 1L;

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";

    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        String line = null;
        // Принял Json обект, прочитал content
        BufferedReader reader = req.getReader();
        // преобразовываю обект в StringBuilder
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        Car car = new Car();
        try {
            JSONObject jsonObject = new JSONObject(sb.toString());
            car.setId("0");
            car.setBrand(jsonObject.getString("brand"));
            car.setModel(jsonObject.getString("model"));
            car.setPrice(jsonObject.getString("price"));
//            car.setImage(new Blob(new byte[10]));
        } catch (JSONException e) {
            throw new IOException("Error parsing JSON request string");
        }



        // checks if the request actually contains upload file
//        if (!ServletFileUpload.isMultipartContent(req)) {
//            // if not, we stop here
//            PrintWriter writer = resp.getWriter();
//            writer.println("Error: Form must has enctype=multipart/form-data.");
//            writer.flush();
//            return;
//        }

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

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

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
                        req.setAttribute("message",
                                "Upload has been done successfully!");
                    }
                }
            }
        } catch (Exception ex) {
            req.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
//        car.setImage(uploadPath.getBytes());
        // redirects client to message page
//        getServletContext().getRequestDispatcher("/message.jsp").forward(
//                req, resp);

        resp.setContentType("text/plain");
        System.out.println("DB call");
        logic.add(car);
//        resp.getWriter().write(logic.addStr(car));
    }
}