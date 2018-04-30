package osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;


/**
 * Created by koldy on 19.04.2018.
 */
public class UsersServlet extends HttpServlet {
    private List<String> user = new CopyOnWriteArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);
    private final UserStore users = UserStore.getInstance();
    public UsersServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        user = users.getAllItems();
        writer.append(String.format("%s", this.user));
        writer.flush();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter(new User().getName());
        this.user.add(name);
        String login = req.getParameter(new User().getLogin());
        this.user.add(login);
        String email = req.getParameter(new User().getEmail());
        this.user.add(email);
        String createDate = req.getParameter(new User().getCreateDate());
        this.user.add(createDate);
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
