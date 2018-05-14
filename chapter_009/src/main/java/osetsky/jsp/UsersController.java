package osetsky.jsp;

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
    private final UserStorage users = UserStorage.getInstance();
//    private final DBStore usersStore = DBStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",UserStorage.getInstance().getUsers());
        req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //создание пользователя
       resp.setContentType("text/hmtl");
       users.addIntoTable(new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), req.getParameter("createDate")));
       users.commit();
       resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
