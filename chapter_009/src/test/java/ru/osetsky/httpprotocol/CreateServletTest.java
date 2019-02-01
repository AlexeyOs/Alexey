package ru.osetsky.httpprotocol;

import org.junit.Test;
import ru.osetsky.httpprotocol.CreateServlet;
import ru.osetsky.httpprotocol.ValidateService;
import ru.osetsky.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.*;

/**
 * Created by koldy on 15.06.2018.
 */
public class CreateServletTest {
    @Test
    public void addUser() throws Exception {
        CreateServlet controller = new CreateServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("root");
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("email")).thenReturn("root@root");
        when(request.getParameter("password")).thenReturn("");
        when(request.getParameter("role")).thenReturn("1");
        when(request.getParameter("createDate")).thenReturn("08.06.2018");
        controller.doPost(request, response);
        List<User> users = ValidateService.getInstance().findAll();
        User user = users.get(users.size() - 1);
        String id = user.getId();
        assertThat(user.getId(), is(id));
    }

}