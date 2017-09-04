package ru.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by koldy on 27.08.2017.
 */
public class IteratorArray implements Iterator {

    /**
     * This field is array.
     */
    private final int[][] arrays;

    /**
     * This field is count type integer.
     */
    private  int count;

    /**
     * This field is value type integer.
     */
    private int value;


    /**
     * Constructor IteratorArray.
     * @param values type integer array [][].
     */
    public IteratorArray(final int[][] values) {
        this.arrays = values;
    }

    /**
     * Method hasNext redefined hasNext.
     * @return result type integer.
     */
    @Override
    public boolean hasNext() {
        return (arrays[count].length > value && arrays.length > count);
    }

    /**
     * Method next redefined next.
     * @return result type integer.
     */
    @Override
    public Object next() {
        if (arrays[count].length <= value) {
            count++;
            value = 0;
        }
        if (hasNext()) {
            int result = arrays[count][value++];
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }
}
