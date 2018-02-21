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

    private Node<E> result;
    private Node<E> find(List<Node<E>> children, E parent) {
        for (Node<E> child : children) {
            if (child.getValue().compareTo(parent) == 0) {
                    result = child;
                    break;
            }
            result = find(child.getChildren(), parent);
        }
        return result;
    }

    private boolean checkRepeat(E child,List<Node<E>> children){
        boolean result = true;
        for (Node<E> childcom : children) {
                if (child.equals(childcom.getValue())) {
                        result = false;
                        return result;
                }
        }
        if (result) {
            for (Node<E> child_down : children) {
                if (child_down.getChildren().size()>0) {
                    result = checkRepeat(child, child_down.getChildren());
                    if (result == false) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public boolean isBinary(){
        return isBinary(root.getChildren());
    }

    private boolean isBinary(List<Node<E>> node) {
        boolean result;
        // если потоков меньше двух, то дерево не бинарное
        for (Node<E> noda: node){
            if (noda.getChildren().size() > 2){
                return false;
            }
        }
        //проверка детей
        for (Node<E> noda: node) {
            //проверка текущего узла
            if (noda.getChildren().size() > 0) {
                result = isBinary(noda.getChildren());
                if (!isBinary(noda.getChildren())) {
                    return result;
                }
            }
        }
        return true;
    }
    @Override
    public boolean add(E parent, E child) {
        Node<E> resultAdd = root;
        if (!root.getValue().equals(parent)&&checkRepeat(child,this.root.getChildren())) {
                resultAdd = find(root.getChildren(), parent);
        }
        boolean parentExists = resultAdd != null;
        if (parentExists && checkRepeat(child,this.root.getChildren())) {
            Node<E> node = new Node<>(child);
            resultAdd.getChildren().add(node);
        }
        return parentExists;
    }

    @Override
    public void add(E e) {

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
