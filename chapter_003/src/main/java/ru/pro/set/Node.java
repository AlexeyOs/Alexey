package ru.pro.set;

/**
 * Created by koldy on 28.09.2017.
 * @param <T> - generic type.
 */
public class Node<T> {

    /**
     * Current element.
     */
    private T current;

    /**
     * Next element.
     */
    private Node<T> next;

    /**
     * Previous element.
     */
    private Node<T> previous;

    /**
     * @param previous - previous position node.
     * @param current - current position node.
     * @param next - next position node.
     */
    public Node(Node<T> previous, T current, Node<T> next) {
        this.current = current;
        this.next = next;
        this.previous = previous;
    }

    /**
     * @return current element.
     */
    public T getCurrent() {
        return this.current;
    }

    /**
     * @return next element.
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * @return previous element.
     */
    public Node<T> getPrevious() {
        return previous;
    }

    /**
     * @param current element.
     */
    public void setCurrent(T current) {
        this.current = current;
    }

    /**
     * @param next element.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * @param previous element.
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    /**
     * @param o - Object for check on uniqueness.
     * @return boolean result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node<?> node = (Node<?>) o;

        if (current != null ? !current.equals(node.current) : node.current != null) {
            return false;
        }
        return true;
    }

    /**
     * @return boolean result for check on uniqueness.
     */
    @Override
    public int hashCode() {
        return current != null ? current.hashCode() : 0;
    }
}
