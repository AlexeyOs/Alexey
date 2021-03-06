package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.Role;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Role role = new Role();
        role.setName(req.getParameter("name"));
        role.setDescription(req.getParameter("description"));
        role.setAddcontent(Boolean.parseBoolean(req.getParameter("addcontent")));
        role.setUpdatecontent(Boolean.parseBoolean(req.getParameter("updatecontent")));
        role.setSeealluser(Boolean.parseBoolean(req.getParameter("seealluser")));
        this.logic.addRole(role);
        resp.sendRedirect(String.format("%s/listrole", req.getContextPath()));
    }
}
