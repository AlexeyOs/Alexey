package ru.osetsky.httpprotocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by koldy on 26.05.2018.
 */
public class ListServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ListServlet.class);
    private final ValidateService logic = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usersParam",  logic.findAll());
        req.getRequestDispatcher("/WEB-INF/views/ListView.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //удаление пользователя
        resp.setContentType("text/html");
        this.logic.delete(req.getQueryString());
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }
}