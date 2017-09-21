package ru.pro.list;

import java.util.LinkedList;

/**
 * Created by koldy on 17.09.2017.
 * @param <T> - generic type.
 */
public class SimpleStack<T> {
    /**
     * Stack object.
     */
    private LinkedList<T> container = new LinkedList<T>();
    /**
     * index for object container.
     */
    private int index = 0;

    /**
     * @return result - last container object.
     */
    public T poll() {
        T result = null;
        if (index > 0) {
            result = container.get(--index);
            container.remove(index);
        }
        return result;
    }

    /**
     * @param value - add container object.
     */
    public void push(T value) {
        this.container.add(value);
        index++;
    }
}

