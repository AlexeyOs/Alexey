package ru.osetsky.httpprotocol;

import org.junit.Test;
import ru.osetsky.httpprotocol.EditRole;
import ru.osetsky.httpprotocol.ValidateService;
import ru.osetsky.models.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by koldy on 06.07.2018.
 */
public class EditRoleTest {
    @Test
    public void editRole() throws Exception {
        EditRole editRole = new EditRole();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("name")).thenReturn("user");
        when(request.getParameter("description")).thenReturn("user");
        when(request.getParameter("addcontent")).thenReturn("true");
        when(request.getParameter("updatecontent")).thenReturn("true");
        when(request.getParameter("seealluser")).thenReturn("false");
        editRole.doPost(request, response);
        Role role = ValidateService.getInstance().findByRole("2");

        assertThat(role.getId(), is("2"));
    }

}