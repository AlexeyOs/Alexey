package ru.pro.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by koldy on 05.02.2018.
 */
public class SearchBinaryTree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public void add(E e){
        if(this.root == null){
            this.root = new Node<E>(e);
        }
        Node<E> node = this.root;
        while (true) {
            if (e.hashCode() < node.getValue().hashCode()){
                if (node.left == null){
                    node.left = new Node<E>(e);
                    return;
                } else {
                    node = node.left;
                }
            } else if (e.hashCode() > node.getValue().hashCode()) {
                if (node.right == null){
                    node.right = new Node<E>(e);
                    return;
                } else  {
                    node = node.right;
                }
            } else {
                return;
            }
        }
    }
    public boolean find(E element){
        boolean isNeedSave = false;
        Node<E> node = this.root;
        while (node != null) {
            if (node.getValue().compareTo(element) > 0) {
                isNeedSave = true;
                break;
            } else if (node.getValue().compareTo(element) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return isNeedSave;
    }
    @Override
    public Iterator<E> iterator() {
        return new SearchBinaryTree.SBinaryTreeIterator();
    }

    @Override
    public boolean add(E parent, E child) {
        return false;
    }

    private class SBinaryTreeIterator implements Iterator<E> {
        private Queue<Node<E>> queue;

        private SBinaryTreeIterator() {
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
