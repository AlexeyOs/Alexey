package osetsky.httpprotocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by koldy on 27.05.2018.
 */
public class CreateServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CreateServlet.class);
    private final ValidateService logic = ValidateService.getInstance();

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
                + "Password : <input type='text' name='password'/>"
                + "<br>"
                + "CreateDate : <input type='text' name='createDate'/>"
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
        String password = req.getParameter("password");
        String createDate = req.getParameter("createDate");
        this.logic.add(name, login, email, password, createDate);
        doGet(req, resp);
    }
}
