package osetsky.httpprotocol;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by koldy on 17.07.2018.
 */
public class JsonServlet extends HttpServlet {
    /**
     * Метод обрабатывает JSON запрос от AJAX.
     * Метод корректно принимает запрос если запустить chrome с указанными ниже параметрами,
     * иначе из-за настроек безопасности метод может не выполнится
     * chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = "Anonymous";
        String password = "p";
        StringBuilder sb = new StringBuilder();
        String line = null;
        // Принял Json обект, прочитал content
        BufferedReader reader = req.getReader();
        // преобразовываю обект в StringBuilder
        while ((line = reader.readLine()) != null)
            sb.append(line);

        try {
            JSONObject jsonObject = new JSONObject(sb.toString());
            userName = jsonObject.getString("userName");
            password = jsonObject.getString("password");
        } catch (JSONException e) {
            throw new IOException("Error parsing JSON request string");
        }
        String greetings = "<tr><td>" + userName + "</td><td>"+ password + "</td></tr>";

        resp.setContentType("text/plain");
        resp.getWriter().write(greetings);
    }

}
