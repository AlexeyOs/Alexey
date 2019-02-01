package ru.osetsky.servlets;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class ItemAdd extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ItemAdd.class);
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/ItemAdd.jsp").forward(req, resp);
    }

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
        Item item = new Item();
        try {
            JSONObject jsonObject = new JSONObject(sb.toString());
            item.setDesc(jsonObject.getString("description"));
//            item.setCreated(jsonObject.getString("created"));
            item.setDone(Boolean.parseBoolean(jsonObject.getString("done")));
        } catch (JSONException e) {
            throw new IOException("Error parsing JSON request string");
        }
        resp.setContentType("text/plain");
        resp.getWriter().write(logic.addStr(item));
    }
}
