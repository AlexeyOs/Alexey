package osetsky.httpprotocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by koldy on 29.06.2018.
 */
public class CreateRole extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CreateServlet.class);
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/CreateRole.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //создание пользователя
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        boolean addcontent = Boolean.parseBoolean(req.getParameter("addcontent"));
        boolean updatecontent = Boolean.parseBoolean(req.getParameter("updatecontent"));
        boolean seealluser = Boolean.parseBoolean(req.getParameter("seealluser"));
        this.logic.addRole(name, description, addcontent, updatecontent, seealluser);
        resp.sendRedirect(String.format("%s/listrole", req.getContextPath()));
    }
}
