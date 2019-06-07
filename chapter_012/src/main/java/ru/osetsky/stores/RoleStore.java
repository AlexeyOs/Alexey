package ru.osetsky.stores;

import java.util.List;

public interface RoleStore<T> {
    public void addRole(T role);
    public void editRole(T role);
    public void deleteRole(T role);
    public List<T> getAllRoles();
}
