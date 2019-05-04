package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.osetsky.models.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by koldy on 29.06.2018.
 */
@Controller
public class EditRole {
    private static final Logger LOG = LoggerFactory.getLogger(EditServlet.class);
    private final ValidateService logic = ValidateService.getInstance();
    private String id;
    private Role role;
    @RequestMapping(value = "/editrole", method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getQueryString();
        req.setAttribute("role",  logic.findRoleBy(id));
        req.getRequestDispatcher("/WEB-INF/views/EditRole.jsp").forward(req, resp);
    }

    @RequestMapping(value = "/editrole", method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // редактирование пользователя
        resp.setContentType("text/html");
        Role role = new Role();
        role.setName(req.getParameter("name"));
        role.setDescription(req.getParameter("description"));
        role.setAddcontent(Boolean.parseBoolean(req.getParameter("addcontent")));
        role.setUpdatecontent(Boolean.parseBoolean(req.getParameter("updatecontent")));
        role.setSeealluser(Boolean.parseBoolean(req.getParameter("seealluser")));
        this.logic.editRole(role);
        resp.sendRedirect(String.format("%s/listrole", req.getContextPath()));
    }
}
