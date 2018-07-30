package osetsky.httpprotocol;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by koldy on 17.07.2018.
 */
public class JsonServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Принял Json обект, прочитал content
        BufferedReader reader = req.getReader();
        // преобразовываю обект в StringBuilder
        StringBuilder builder = new StringBuilder();
        String aux = "";
        while ((aux = reader.readLine()) != null) {
            builder.append(aux);
        }

        String text = builder.toString();
        // с помощью библиотеки jakson преобразовываю в объект.
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode studentNode = mapper.readTree(text);
        // храню в ConcurrentHashMap
        Map<String, Object> map = mapper.readValue(studentNode, HashMap.class);
        new ConcurrentHashMap<>(map);
    }
}
