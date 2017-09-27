package ru.pro.set;


import java.util.Iterator;

/**
 * Created by koldy on 26.09.2017.
 * @param <T> generic type.
 */
public class SimpleSetArray<T> implements ISimpleSet<T> {
    /**
     * Array objects.
     */
    private Object[] container;

    /**
     * length of container.
     */
    private int length = 10;

    /**
     * count elements of container.
     */
    private int count = 0;

    /**
     *
     */
    public SimpleSetArray() {
        container = new Object[this.length];
    }

    /**
     * @param value
     */
    @Override
    public void add(T value) {
        boolean dubl = checkDubl(value);
        if (this.count < this.length && dubl) {
            this.container[count] = value;
            count++;
        } else if (this.count >= this.length && dubl) {
            makeExpand();
            this.container[count] = value;
            count++;
        }

    }

    /**
     * Make expand if need.
     */
    private void makeExpand() {
        this.length *= 2;
        Object[] tmpArray = new Object[this.length];
        System.arraycopy(this.container, 0, tmpArray, 0, container.length);
        container = tmpArray;
    }

    /**
     * Check duplicate.
     * @param value to check.
     * @return boolean result.
     */
    private boolean checkDubl(T value) {
        for (int i = 0; i < count; i++) {
            if (this.container[i].equals(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return this.position < length;
            }

            @Override
            public T next() {
                return  (T) container[this.position++];
            }
        };
    }

    /**
     * @return count elements of container.
     */
    public int getCount() {
        return this.count;
    }
}
