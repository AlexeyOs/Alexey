package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by koldy on 29.06.2018.
 */
public class ListRole extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(EditServlet.class);
    private final ValidateService logic = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("roles",  logic.findAllRoles());
        req.getRequestDispatcher("/WEB-INF/views/ListRole.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //удаление пользователя
        resp.setContentType("text/html");
//        this.logic.deleteRole(req.getQueryString());
        resp.sendRedirect(String.format("%s/listrole", req.getContextPath()));
    }
}
