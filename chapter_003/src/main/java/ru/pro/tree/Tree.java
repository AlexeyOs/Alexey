package ru.pro.tree;

import java.util.*;

/**
 * Created by koldy on 26.10.2017.
 */
class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(Node<E> root) {
        this.root = root;
    }

    private Node<E> find(List<Node<E>> children, E parent) {
        Node<E> result = null;
        for (Node<E> child : children) {
            if (child.getValue().compareTo(parent) == 0) {
                result = child;
                break;
            }
            result = find(child.getChildren(), parent);
        }
        return result;
    }


    @Override
    public boolean add(E parent, E child) {
        Node<E> resultAdd = root;
        if (root.getValue().compareTo(parent) != 0) {
            resultAdd = find(root.getChildren(), parent);
        }
        boolean parentExists = resultAdd != null;
        if (parentExists) {
            Node<E> node = new Node<>(child);
            resultAdd.getChildren().add(node);
        }
        return parentExists;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }
    private class TreeIterator implements Iterator<E> {
        private Queue<Node<E>> queue;

        private TreeIterator() {
            queue = new LinkedList<>();
            queue.add(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            Node<E> result = queue.poll();
            queue.addAll(result.getChildren());
            return result.getValue();
        }
    }
}
