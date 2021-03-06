package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
 * Created by koldy on 27.05.2018.
 */
@Controller
public class CreateServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CreateServlet.class);
    private final ValidateService logic = ValidateService.getInstance();

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/CreateView.jsp").forward(req, resp);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //создание пользователя
        resp.setContentType("text/html");
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("login"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setRole(Integer.parseInt(req.getParameter("role")));
        user.setCreateDate(Timestamp.valueOf(req.getParameter("createDate")));
        user.setCountry(req.getParameter("country"));
        user.setCity(req.getParameter("city"));

        this.logic.addUser(user);
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }
}
