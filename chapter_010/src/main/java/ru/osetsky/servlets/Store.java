package ru.osetsky.servlets;

import ru.osetsky.models.Item;

import java.util.List;

/**
 * Created by koldy on 17.01.2019.
 */
public interface Store {
    public void add(Item item);
    public List<Item> getAll();
}
