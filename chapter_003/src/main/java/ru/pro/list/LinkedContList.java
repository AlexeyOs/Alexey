package ru.pro.list;

import java.util.Iterator;

/**
 * Created by koldy on 16.09.2017.
 * @param <T> - generic type.
 */
public class LinkedContList<T> implements SimpleList {

    /**
     * Node of linkedList.
     * @param <T> - generic type.
     */
    public class Node<T> {
        /**
         * value of Node.
         */
        private Object value;
        /**
         * method next for list.
         */
        private Node<T> next;
    }

    /**
     * Head of list.
     */
    private Node<T> head;

    /**
     * tail if list.
     */
    private Node<T> tail;


    /**
     * @param value - item to add.
     */
    @Override
    public void add(Object value) {
        Node<T> node  = new Node<>();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    /**
     * @param index - index of item to get.
     * @return
     */
    @Override
    public T get(int index) {
        Node<T> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return (T) result.value;
    }

    /**
     * @return iterator.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return head.next != null;
            }

            @Override
            public Object next() {
                Node<T> result = current;
                current = current.next;
                return result;
            }
        };
    }
}
