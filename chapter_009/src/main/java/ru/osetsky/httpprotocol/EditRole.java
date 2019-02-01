package ru.osetsky.httpprotocol;

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
public class EditRole extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(EditServlet.class);
    private final ValidateService logic = ValidateService.getInstance();
    private String id;
    private Role role;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getQueryString();
        req.setAttribute("role",  logic.findByRole(id));
        req.getRequestDispatcher("/WEB-INF/views/EditRole.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // редактирование пользователя
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        boolean addcontent = Boolean.parseBoolean(req.getParameter("addcontent"));
        boolean updatecontent = Boolean.parseBoolean(req.getParameter("updatecontent"));
        boolean seealluser = Boolean.parseBoolean(req.getParameter("seealluser"));
        this.logic.updateRole(id, name, description, addcontent, updatecontent, seealluser);
        resp.sendRedirect(String.format("%s/listrole", req.getContextPath()));
    }
}
