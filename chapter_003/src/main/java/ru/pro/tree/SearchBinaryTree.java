package ru.pro.tree;

/**
 * Created by koldy on 05.02.2018.
 */
public class SearchBinaryTree<E> {
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
            if (node.getValue().hashCode() == element.hashCode()) {
                isNeedSave = true;
                break;
            } else if (node.getValue().hashCode() > element.hashCode()) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return isNeedSave;
    }
}
