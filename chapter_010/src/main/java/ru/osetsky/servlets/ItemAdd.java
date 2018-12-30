package ru.osetsky.servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.Item;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class ItemAdd extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ItemAdd.class);
    private Item item;
    /**
     * Метод обрабатывает JSON запрос от AJAX.
     * Метод корректно принимает запрос если запустить chrome с указанными ниже параметрами,
     * иначе из-за настроек безопасности метод может не выполнится
     * chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = null;
        // Принял Json обект, прочитал content
        BufferedReader reader = req.getReader();
        // преобразовываю обект в StringBuilder
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String description;
        String created;
        String done;
        try {
            JSONObject jsonObject = new JSONObject(sb.toString());
            description = jsonObject.getString("description");
            created = jsonObject.getString("created");
            done = jsonObject.getString("done");
        } catch (JSONException e) {
            throw new IOException("Error parsing JSON request string");
        }

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setDesc(description);
        item.setDone(done);
        session.save(item);
        session.getTransaction().commit();
        session.close();
        factory.close();
        String greetings ="<tr><td>" + description + "</td><td>" + created + "</td><td>" + done + "</td></tr>";

        resp.setContentType("text/plain");
        resp.getWriter().write(greetings);
    }
}
