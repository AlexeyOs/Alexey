package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Component
public class EditServlet {
    private static final Logger LOG = LoggerFactory.getLogger(EditServlet.class);
    private final ValidateService logic = ValidateService.getInstance();
    private String id;
    private User user;
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getQueryString();
        req.setAttribute("user",  logic.findUserBy(id));
        if (logic.checkAdminRoles()) {
            req.setAttribute("admin", logic.findUserBy(id));
        }
        req.getRequestDispatcher("/WEB-INF/views/EditView.jsp").forward(req, resp);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
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

