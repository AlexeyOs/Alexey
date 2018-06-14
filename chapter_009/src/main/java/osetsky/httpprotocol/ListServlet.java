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
import java.util.List;

/**
 * Created by koldy on 26.05.2018.
 */
public class ListServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ListServlet.class);
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        StringBuilder sb = new StringBuilder("<table>");
        List<User> usersParam = logic.findAll();
        // формирование html формы.
        sb.append("<tr>");
        for (User user:usersParam) {
            //выводит всех пользователей.
            sb.append("<td>" + user.getId()+ "</td>");
            sb.append("<td>" + user.getName()+ "</td>");
            sb.append("<td>" + user.getEmail()+ "</td>");
            sb.append("<td>" + user.getLogin()+ "</td>");
            sb.append("<td>" + user.getCreateDate()+ "</td>");
            sb.append("<td><form action='" + req.getContextPath() + "/list?" + user.getId() + "' method='post'><input type='submit' value='Delete'></form></td>");
            sb.append("<td><a href=" + req.getContextPath() + "/edit?" + user.getId() + "><input type='submit' value='Edit'></a></td>");
            sb.append("</tr><tr>");
            sb.append("</tr><tr>");
        }
        sb.append("</tr><tr>");
        sb.append("<td><a href=" + req.getContextPath() + "/create ><input type='submit' value='Create'></a></td>");
        sb.append("</tr>");
        sb.append("</table>");

        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Title</title>"
                + "</head>"
                + "<body>"
                + sb.toString()
                + "</body>"
                + "</html>");
        writer.flush();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //удаление пользователя
        resp.setContentType("text/html");
        this.logic.delete(req.getQueryString());
        doGet(req, resp);
    }
}