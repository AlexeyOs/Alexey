package ru.pro.list;

import java.util.Iterator;

/**
 * Created by koldy on 09.09.2017.
 * @param <E> - generic.
 */
public class DynamicList<E> implements SimpleList<E> {
    /**
     * Array of object.
     */
    private Object[] container;

    /**
     * Index for Object[] container.
     */
    private int index = 0;

    /**
     * Default length Object[].
     */
    private int length = 10;

    /**
     * Default constructor.
     */
    public DynamicList() {
        container = new Object[this.length];
    }

    /**
     * Constructor with by setting length.
     * @param length is by setting length for Object.
     */
    public DynamicList(int length) {
        this.container = new Object[length];
    }

    /**
     * Method expand array of doubly.
     */
    private void makeExpand() {
        this.length *= 2;
        Object[] tempArray = new Object[length];
        System.arraycopy(this.container, 0, tempArray, 0, container.length);
        container = tempArray;
    }

    /**
     * Method add object to array(Object[]).
     * @param value - object to add.
     */
    @Override
    public void add(E value) {

        if (this.index == this.container.length) {
            makeExpand();
        }
        container[index++] = value;
    }

    /**
     * @param index - index of item to get.
     * @return container - array(Object[]).
     */
    @Override
    public E get(int index) {
        return (E) container[index];
    }

    /**
     * Get iterator for passing container.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return index > this.position;
            }

            @Override
            public E next() {
                return (E) container[this.position++];
            }
        };
    }
}
