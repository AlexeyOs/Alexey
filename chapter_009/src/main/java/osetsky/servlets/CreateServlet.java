package osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by koldy on 19.04.2018.
 */
public class CreateServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CreateServlet.class);
    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        // формирование html формы.
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Title</title>"
                + "</head>"
                + "<body>"
                + "<form action='" + req.getContextPath() + "/create' method='post'>"
                + "Name : <input type='text' name='name'/>"
                + "<br>"
                + "Login : <input type='text' name='login'/>"
                + "<br>"
                + "Email : <input type='text' name='email'/>"
                + "<br>"
                + "createDate : <input type='text' name='createDate'/>"
                + "<input type='submit'>"
                + "</form>"
                + "<br>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //создание пользователя
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String createDate = req.getParameter("createDate");
        this.users.addIntoTable(name, login, email, createDate);
        this.users.commit();
        doGet(req, resp);
    }
}
