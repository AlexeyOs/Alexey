package ru.osetsky.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.osetsky.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by koldy on 01.06.2018.
 */
@Controller
public class SigninController {
    private final ValidateService logic = ValidateService.getInstance();

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/LoginView.jsp").forward(req, resp);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (ValidateService.getInstance().isCredentional(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            User user = logic.findByLoginAndPass(login, password);
            resp.sendRedirect(String.format("%s/carAll",req.getContextPath()));
//            resp.sendRedirect(String.format("%s/edit?" + user.getId(), req.getContextPath()));
        } else {
            req.setAttribute("error", "Credentional invalid");
            doGet(req, resp);
        }
    }
}
