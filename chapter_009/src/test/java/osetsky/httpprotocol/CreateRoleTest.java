package osetsky.httpprotocol;

import org.junit.Test;
import osetsky.models.Role;
import osetsky.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by koldy on 06.07.2018.
 */
public class CreateRoleTest {
    @Test
    public void addRole() throws Exception {
        CreateRole createRole = new CreateRole();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("writer");
        when(request.getParameter("description")).thenReturn("write to content");
        when(request.getParameter("addcontent")).thenReturn("true");
        when(request.getParameter("updatecontent")).thenReturn("true");
        when(request.getParameter("seealluser")).thenReturn("false");
        createRole.doPost(request, response);
        List<Role> users = ValidateService.getInstance().findAllRoles();
        Role role = users.get(users.size() - 1);
        String id = role.getId();
        assertThat(role.getId(), is(id));
    }

}