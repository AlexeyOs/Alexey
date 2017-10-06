package ru.pro.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by koldy on 28.09.2017.
 * @param <T> - generic type.
 */
public class SimpleLinkedSet<T> implements Iterable<T> {
    /**
     *
     */
    private int size = 0;
    /**
     * First node.
     */
    private Node<T> firstNode;
    /**
     * Last node.
     */
    private Node<T> lastNode;

    /**
     * Constructor.
     */
    public SimpleLinkedSet() {
        this.lastNode = new Node<T>(null, null, null);
        this.firstNode = new Node<T>(null, null, this.lastNode);
        this.lastNode.setPrevious(this.firstNode);
    }

    /**
     * @param value - object which check on original.
     * @return boolean result about check on original.
     */
    private boolean checkOriginal(T value) {
        boolean original = true;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            T t = (T) iterator.next();
            if (t.equals(value)) {
                original = false;
                break;
            }
        }
        return original;
    }

    /**
     * @param value - object which add  to Node.
     */
    public void add(T value) {
         if (checkOriginal(value)) {
             Node<T> prev = lastNode;
             prev.setCurrent(value);
             this.lastNode = new Node<T>(prev, null, null);
             prev.setNext(this.lastNode);
             this.size++;
         }
    }

    /**
     * @return new object.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;
            private Node node = firstNode;
            @Override
            public boolean hasNext() {
                return size > this.position;
            }

            @Override
            public T next() {
                node = returnNextNode(node);
                position++;
                if (node == null) {
                    throw new NoSuchElementException("no elements");

                }
                return (T) node.getCurrent();
            }
        };
    }

    /**
     * get next node.
     *
     * @param node node of set.
     * @return next node.
     */
    private Node<T> returnNextNode(Node node) {
        return node.getNext();
    }

    /**
     * @return size - count elements of array.
     */
    public int getSize() {
        return size;
    }
}
