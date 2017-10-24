package ru.pro.referencebook;

import java.util.Iterator;

/**
 * Created by koldy on 24.10.2017.
 */
public class ReferenceBook<T, V> implements Iterable {
    private int size = 0;
    /**
     * Массив, элементы которого будут добавляться в справочник.
     */
    private Node<T, V>[] nodes;
//    public boolean insert(T key, V value) {
//
//    }
//    V get(T key) {
//
//    }
//    boolean delete(T key){
//        return true;
//    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

    private class Node<T, V> {
        private int key;
        private int hash;
        private V value;
        private Node<T, V> next;

        public Node(int key, int hash, V value, Node<T, V> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }

        public Node next() {
            return this.next;
        }

        public V getValue() {
            return this.value;
        }
    }

}
