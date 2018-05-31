package osetsky.httpprotocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
  * Created by koldy on 19.04.2018.
  */
public class UsersController extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(UsersController.class);
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", logic.findAll());
        req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //создание пользователя
        resp.setContentType("text/hmtl");
        logic.add(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), req.getParameter("createDate"));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}