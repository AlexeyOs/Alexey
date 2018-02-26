package ru.pro.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koldy on 13.11.2017.
 */
public class Node<E> {
    private List<Node<E>> children;
    public List<Node<E>> leftright;
    private E value;

    public Node(E value) {
        this.children = new ArrayList<>();
        this.value = value;
    }

    public Node<E> left;
    public Node<E> right;
    public List<Node<E>> getLeftRight() {
        for (Node<E> child : leftright) {
            if (!child.getValue().equals(left)) {
                leftright.add(left);
            } else if (!child.getValue().equals(right)){
                leftright.add(right);
            }
        }
        return leftright;
    }
    public List<Node<E>> getChildren() {
        return children;
    }

    public E getValue() {
        return value;
    }
}
