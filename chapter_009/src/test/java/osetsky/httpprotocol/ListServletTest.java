package osetsky.httpprotocol;

import org.junit.Test;
import osetsky.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by koldy on 27.06.2018.
 */
public class ListServletTest {
    @Test
    public void addAndDeleteUser() throws Exception {
        CreateServlet createServlet = new CreateServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("root");
        when(request.getParameter("login")).thenReturn("root");
        when(request.getParameter("email")).thenReturn("root@root");
        when(request.getParameter("password")).thenReturn("");
        when(request.getParameter("role")).thenReturn("1");
        when(request.getParameter("createDate")).thenReturn("08.06.2018");
        createServlet.doPost(request, response);
        List<User> usersAddNewUser = ValidateService.getInstance().findAll();
        User user = usersAddNewUser.get(usersAddNewUser.size() - 1);
        String idAddNewUser = user.getId();
        ListServlet listServlet = new ListServlet();
        listServlet.doPost(request,response);
        List<User> usersWithoutDeleted = ValidateService.getInstance().findAll();
        User userWithoutDeleted = usersWithoutDeleted.get(usersWithoutDeleted.size() - 1);
        String idWithoutDeleted = user.getId();
        if (!idWithoutDeleted.equals(idAddNewUser)) {
            assertThat(userWithoutDeleted.getId(), is(idWithoutDeleted));
        }
    }

}