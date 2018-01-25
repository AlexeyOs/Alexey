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
                if (checkRepeat(child.getValue(),children)) {
                    result = child;
                    break;
                }
            }
            result = find(child.getChildren(), parent);
        }
        return result;
    }

    private boolean checkRepeat(E child,List<Node<E>> children){
        boolean result = true;
        int count = 0;
        for (Node<E> childall : children) {
            if (child.equals(childall.getValue())) {
                if (count > 0 & count <= 1) {
                    result = false;
                    break;
                }
                count++;
            }
        }
        return result;
    }

    public boolean isBinary(){
        return isBinary(root);
    }

    private boolean isBinary(Node<E> node) {
        boolean result;
        // если потоков миньше двух, то дерево не бинарное
        if (node.getChildren().size() > 2){
            return false;
        } else {
            //проверка детей
            for (Node<E> noda: node.getChildren()) {
                //проверка текущего узла
                result = isBinary(noda);
                if (!result) {
                    return result;
                }
            }
        }
        return true;
    }
    @Override
    public boolean add(E parent, E child) {
        Node<E> resultAdd = root;
        if (!root.getValue().equals(parent)) {
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
