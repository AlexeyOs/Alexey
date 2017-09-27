package ru.pro.set;


/**
 * Created by koldy on 26.09.2017.
 * @param <T> - generic type.
 */
public interface ISimpleSet<T> extends Iterable<T> {
    /**
     * Add new item to container.
     * @param value - new value.
     */
     void add(T value);
}
