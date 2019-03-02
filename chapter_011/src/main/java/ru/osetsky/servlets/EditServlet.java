package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by koldy on 26.05.2018.
 */
public class EditServlet  extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(EditServlet.class);
    private final ValidateService logic = ValidateService.getInstance();
    private String id;
    private User user;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getQueryString();
        req.setAttribute("user",  logic.findUserBy(id));
        if (logic.checkAdminRoles()) {
            req.setAttribute("admin", logic.findUserBy(id));
        }
        req.getRequestDispatcher("/WEB-INF/views/EditView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // редактирование пользователя
        resp.setContentType("text/html");
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("login"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setCreateDate(Timestamp.valueOf(req.getParameter("createDate")));
        user.setCountry(req.getParameter("country"));
        user.setCity(req.getParameter("city"));
        this.logic.editUser(user);
        resp.sendRedirect(String.format("%s/listrole", req.getContextPath()));
    }
}

