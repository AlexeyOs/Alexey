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
public class JSPServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(JSPServlet.class);
//    private final UserStorage users = UserStorage.getInstance();
    private final DBStore usersStore = DBStore.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //создание пользователя
       resp.setContentType("text/hmtl");
       usersStore.addIntoTable(new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email"), req.getParameter("createDate")));
//       usersStore.commit();
       resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
}
