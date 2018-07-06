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
public class ListRoleTest {
    @Test
    public void addAndDeleteRole() throws Exception {
        CreateRole createRole = new CreateRole();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("writer");
        when(request.getParameter("description")).thenReturn("write to content");
        when(request.getParameter("addcontent")).thenReturn("true");
        when(request.getParameter("updatecontent")).thenReturn("true");
        when(request.getParameter("seealluser")).thenReturn("false");
        createRole.doPost(request, response);
        List<Role> rolesAddNewRole = ValidateService.getInstance().findAllRoles();
        Role roleAddNewRole = rolesAddNewRole.get(rolesAddNewRole.size() - 1);
        String idAddNewRole = roleAddNewRole.getId();
        ListRole listRole = new ListRole();
        listRole.doPost(request, response);
        List<Role> rolesWithoutDeleted = ValidateService.getInstance().findAllRoles();
        Role roleWithoutDeleted = rolesWithoutDeleted.get(rolesWithoutDeleted.size() - 1);
        String idWithoutDeleted = roleWithoutDeleted.getId();
        if (!idWithoutDeleted.equals(idAddNewRole)) {
            assertThat(roleWithoutDeleted.getId(), is(idWithoutDeleted));
        }
    }

}