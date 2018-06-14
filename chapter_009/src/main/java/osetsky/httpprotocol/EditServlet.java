package osetsky.httpprotocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import osetsky.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        id = req.getQueryString();
        user = logic.findBy(id);
        // формирование html формы.
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Title</title>"
                + "</head>"
                + "<body>"
                + "<form action='" + req.getContextPath() + "/edit' method='post'>"
                + "Name : <input type='text' name='name' value='" + user.getName() + "'/>"
                + "<br>"
                + "Login : <input type='text' name='login' value='" + user.getLogin() + "'/>"
                + "<br>"
                + "Email : <input type='text' name='email' value='" + user.getEmail() + "'/>"
                + "<br>"
                + "CreateDate : <input type='text' name='createDate' value='" + user.getCreateDate() + "'/>"
                + "<input type='submit'>"
                + "</form>"
                + "<br>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // редактирование пользователя
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String createDate = req.getParameter("createDate");
        this.logic.update(id, name, login, email,createDate);
    }
}

