package ru.pro.list;

/**
 * Created by koldy on 09.09.2017.
 * @param <T> - generic.
 */
public interface SimpleList<T> extends Iterable<T> {
    /**
     * Add item to list.
     * @param value - item to add..
     */
    void add(T value);
    /**
     * get item from list.
     * @param index - index of item to get.
     * @return - item.
     */
    T get(int index);
}
