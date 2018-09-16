package osetsky.httpprotocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import osetsky.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by koldy on 01.06.2018.
 */
public class SigninController extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/LoginView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (ValidateService.getInstance().isCredentional(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            User user = logic.findByLoginAndPass(login, password);
            resp.sendRedirect(String.format("%s/edit?" + user.getId(), req.getContextPath()));
        } else {
            req.setAttribute("error", "Credentional invalid");
            doGet(req, resp);
        }
    }
}
