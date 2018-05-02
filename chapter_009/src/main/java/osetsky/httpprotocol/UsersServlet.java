package osetsky.httpprotocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Created by koldy on 19.04.2018.
 */
public class UsersServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);
    private final UserStore users = UserStore.getInstance();
    public UsersServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(String.format("%s", users.getAllItems()));
        writer.flush();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter(new User().getName());
        String login = req.getParameter(new User().getLogin());
        String email = req.getParameter(new User().getEmail());
        String createDate = req.getParameter(new User().getCreateDate());
        users.addIntoTable(name, login, email, createDate);
        users.commit();
        //doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        String name = req.getParameter(new User().getName());
        String login = req.getParameter(new User().getLogin());
        String email = req.getParameter(new User().getEmail());
        String createDate = req.getParameter(new User().getCreateDate());
        users.updateTable(id, name, login, email, createDate);
        users.commit();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        users.deleteTable(req.getParameter("id"));
        users.commit();
    }

}
