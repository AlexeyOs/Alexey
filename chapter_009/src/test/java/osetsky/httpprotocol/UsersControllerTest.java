package osetsky.httpprotocol;



import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import osetsky.models.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;


/**
 * Created by koldy on 15.06.2018.
 */
public class UsersControllerTest {
    @Test
    public void doPost() throws ServletException, IOException {
        UsersController controller = new UsersController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("root");
        controller.doPost(request, response);
        List<User> users = ValidateService.getInstance().findAll();

        assertThat(users.get(0).getLogin(), is("root"));
    }

}