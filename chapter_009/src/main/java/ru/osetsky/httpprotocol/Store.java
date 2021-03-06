package ru.osetsky.httpprotocol;

import ru.osetsky.models.Role;
import ru.osetsky.models.User;

import java.util.List;

/**
 * Created by koldy on 15.05.2018.
 */
public interface Store {
    public void add(String name, String login, String email, String password,
                    int role, String createDate, String country, String city);
    public void update(String id, String name, String login, String email,
                       String password, String createDate, String country, String city);
    public void delete(String id);
    public List<User> findAll();
    public User findBy(String id);
    public void addRole(String name, String description, boolean addcontent, boolean updatecontent, boolean seealluser);
    public void updateRole(String id, String name, String description, boolean addcontent, boolean updatecontent, boolean seealluser);
    public void deleteRole(String id);
    public List<Role> findAllRoles();
    public Role findByRole(String id);
}
