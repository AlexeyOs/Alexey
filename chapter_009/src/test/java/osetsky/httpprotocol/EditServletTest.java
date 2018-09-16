package osetsky.httpprotocol;

import org.junit.Test;
import osetsky.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by koldy on 15.06.2018.
 */
public class EditServletTest {
    @Test
    public void editUser() throws ServletException, IOException {
        EditServlet controller = new EditServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("admin");
        when(request.getParameter("login")).thenReturn("admin");
        when(request.getParameter("email")).thenReturn("alexeyosetsky@gmail.com");
        when(request.getParameter("password")).thenReturn("1234");
        when(request.getParameter("createDate")).thenReturn("08.06.2018");
        when(request.getParameter("country")).thenReturn("Russia");
        when(request.getParameter("city")).thenReturn("Krasnodar");
        controller.doPost(request, response);
        User user = ValidateService.getInstance().findBy("1");

        assertThat(user.getId(), is("1"));
    }
}