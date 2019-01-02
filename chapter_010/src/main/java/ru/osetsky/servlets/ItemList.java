package ru.osetsky.servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.Item;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ItemList extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ItemAdd.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        StringBuilder stringBuilder = new StringBuilder();
        List<Item> itemList = session.createQuery("from Item").list();
        for (Item item1 : itemList){
            stringBuilder.append("<tr><td>");
            stringBuilder.append(item1.getDesc());
            stringBuilder.append("</td><td>");
            stringBuilder.append(item1.getCreated());
            stringBuilder.append("</td><td>");
            if (item1.getDone()) {
                stringBuilder.append("<input type=\"checkbox\" id=\"" + item1.getId() + "\" checked onchange=\"taskReady(id)\">");
            } else {
                stringBuilder.append("<input type=\"checkbox\" id=\"" + item1.getId() + "\" onchange=\"taskReady(id)\">");
            }
            stringBuilder.append("</td></tr>");
        }
        session.getTransaction().commit();
        session.close();
        factory.close();

        resp.setContentType("text/plain");
        resp.getWriter().write(stringBuilder.toString());
    }
}
