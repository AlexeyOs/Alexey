package ru.pro.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

/**
 * Created by koldy on 26.09.2017.
 * @param <T> - generic type.
 */
@ThreadSafe
public class CycleList<T> implements Iterable<T> {
    @GuardedBy("this")
    /**
     * first node.
     */
    private Node<T> firstNode;

    /**
     * last node.
     */
    private Node<T> lastNode;

    /**
     * list size.
     */
    private int size = 0;

    /**
     * @param value - value for add.
     */
    public synchronized void addNoCycle(T value) {
        Node<T> tmp = lastNode;
        Node<T> node  = new Node(value, null);
        lastNode = node;
        if (tmp == null) {
            firstNode = node;
        } else {
            tmp.next = null;
        }
        size++;
    }

    /**
     * @param value - value for add.
     */
    public synchronized void addToWithCycle(T value) {
        Node<T> tmp = lastNode;
        Node<T> node = new Node<>(value, firstNode);
        lastNode = node;
        if (tmp == null) {
            firstNode = node;
        } else {
            tmp.next = node;
        }
        size++;
    }


    /**
     * @return
     */
    @Override
    public synchronized Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pointer = 0;
            private Node tmp = null;

            @Override
            public boolean hasNext() {
                return pointer > size;
            }

            @Override
            public T next() {
                if (pointer == 0) {
                    tmp = firstNode;
                } else {
                    tmp = tmp.next;
                }
                pointer++;
                return (T) tmp.value;
            }
        };
    }

    /**
     * @param <T> - object for initialize.
     */
    class Node<T> {
        /**
         * Value of Node.
         */
        private T value;
        /**
         * link to next.
         */
        private Node<T> next;

        /**
         * @param value - value.
         * @param next - link to next.
         */
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * @param first - first node.
     * @return boolean result which find cycle.
     */
    boolean hasCycle(Node first) {
        Iterator itOne = this.iterator();
        Iterator itTwo = this.iterator();
        try {
            while (true) {
                T one = (T) itOne.next();
                itTwo.next();
                T two = (T) itTwo.next();
                if (one.equals(two)) {
                    return true;
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * @return object firstNode.
     */
    public synchronized Node<T> getFirstNode() {
        return firstNode;
    }

}
