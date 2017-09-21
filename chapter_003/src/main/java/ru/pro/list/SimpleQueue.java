package ru.pro.list;

import java.util.LinkedList;

/**
 * Created by koldy on 17.09.2017.
 * @param <T> - generic type.
 */
public class SimpleQueue<T> {
    /**
     * Stack object.
     */
    private LinkedList<T> container = new LinkedList<T>();
    /**
     * index for object container.
     */
    private int index = 0;

    /**
     * @return result - first added container object.
     */
    public T poll() {
        T result = null;
        if (index > 0) {
            result = container.get(0);
            container.remove(0);
        }
        return result;
    }

    /**
     * @param value - add container object.
     */
    public void push(T value) {
        container.add(value);
        index++;
    }
}
