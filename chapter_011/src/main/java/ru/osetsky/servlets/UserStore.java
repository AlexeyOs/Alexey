package ru.osetsky.servlets;

import ru.osetsky.models.User;

import java.util.List;

public interface UserStore<T> {
    public void addUser(T user);
    public void editUser(T user);
    public void deleteUser(T user);
    public List<T> getAllUsers();
}
