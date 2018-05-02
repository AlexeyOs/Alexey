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
 * Created by koldy on 01.05.2018.
 */
public class EditServlet  extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CreateServlet.class);
    private final UserStore users = UserStore.getInstance();
    private String id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        id = req.getQueryString();
        // формирование html формы.
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Title</title>"
                + "</head>"
                + "<body>"
                + "<form action='" + req.getContextPath() + "/edit' method='post'>"
                + "Name : <input type='text' name='name' value='" + users.getItemParam(id, "name") + "'/>"
                + "<br>"
                + "Login : <input type='text' name='login' value='" + users.getItemParam(id, "login") + "'/>"
                + "<br>"
                + "Email : <input type='text' name='email' value='" + users.getItemParam(id, "email") + "'/>"
                + "<br>"
                + "createDate : <input type='text' name='createDate' value='" + users.getItemParam(id, "createDate") + "'/>"
                + "<input type='submit'>"
                + "</form>"
                + "<br>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // редактирование пользователя
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String createDate = req.getParameter("createDate");
        this.users.updateTable(id, name, login, email, createDate);
        this.users.commit();
    }
}
