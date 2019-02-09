package ru.osetsky.servlets;


import java.util.List;

/**
 * Created by koldy on 17.01.2019.
 */
public interface Store<T> {
    public void add(T item);
    public void edit(T item);
    public void delete(T item);
    public List<T> getAll();
}
