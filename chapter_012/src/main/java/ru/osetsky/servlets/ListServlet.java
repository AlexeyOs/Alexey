package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.osetsky.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by koldy on 26.05.2018.
 */
@Controller
public class ListServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ListServlet.class);
    private final ValidateService logic = ValidateService.getInstance();
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usersParam",  logic.getAllUsers());
        req.getRequestDispatcher("/WEB-INF/views/ListView.jsp").forward(req, resp);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //удаление пользователя
        resp.setContentType("text/html");
        User user = new User();
        user.setId(req.getQueryString());
        this.logic.deleteUser(user);
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }
}