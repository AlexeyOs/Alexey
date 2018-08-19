package osetsky.httpprotocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import osetsky.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        req.setAttribute("user",  logic.findBy(id));
        if (logic.checkAdminRoles()) {
            req.setAttribute("admin", logic.findBy(id));
        }
        req.getRequestDispatcher("/WEB-INF/views/EditView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // редактирование пользователя
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String createDate = req.getParameter("createDate");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        this.logic.update(id, name, login, email, password, createDate, country, city);
        resp.sendRedirect(String.format("%s/edit", req.getContextPath()));
    }
}

