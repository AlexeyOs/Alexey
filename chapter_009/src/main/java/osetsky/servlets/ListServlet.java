package osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koldy on 01.05.2018.
 */
public class ListServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CreateServlet.class);
    private final UserStore users = UserStore.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        StringBuilder sb = new StringBuilder("<table>");
        List<String> usersParam = users.getAllItems();
        // массив для того чтобы параметры(name,login,email,createDate) выстроить в виде таблицы.
        List<Integer> arrNumber = new ArrayList<>();
        // так как нумерация массива начинается с 0, то я сделал массив значения, где хранятся
        // индексы конца строки(таблицы(name,login,email,createDate)) первый индекс будет равен 4
        // а последующие на 5 увеличиваются.
        int k = 4;
        List<Integer> numberButton = users.getAllIdItems();
        for (int i = 0; i <= usersParam.size(); i++) {
            if (i == k) {
                arrNumber.add(k);
                k = k + 5;
            }
        }
        // формирование html формы.
        sb.append("<tr>");
        int index = 0;
        for (int i = 0; i < usersParam.size(); i++) {
            //выводит всех пользователей.
            sb.append("<td>" + usersParam.get(i) + "</td>");
            if (i % arrNumber.get(index) == 0 && i != 0) {
                sb.append("<td><form action='" + req.getContextPath() + "/list?" + numberButton.get(index) + "' method='post'><input type='submit' value='Delete'></form></td>");
                sb.append("<td><a href=" + req.getContextPath() + "/edit?" + numberButton.get(index) + "><input type='submit' value='Edit'></a></td>");
                sb.append("</tr><tr>");
                index++;
            }
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
        this.users.deleteTable(req.getQueryString());
        this.users.commit();
        doGet(req, resp);
    }
}
