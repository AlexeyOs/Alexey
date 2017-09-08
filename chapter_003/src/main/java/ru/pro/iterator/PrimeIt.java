package ru.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by koldy on 07.09.2017.
 */
public class PrimeIt implements Iterator {
    /**
     * Field is array type integer.
     */
    private int[] arrays;
    /**
     * Field is index type integer.
     */
    private int index = -1;
    /**
     * Constructor PrimeIt.
     * @param numbers is array type integer.
     */
    public PrimeIt(final int[] numbers) {
        this.arrays = numbers;
    }
    /**
     * Redefined method hasNext.
     * @return f variable, which will show if there are simple numbers after the pointer.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index + 1; i < this.arrays.length; i++) {
            if (this.arrays[i] % 2 != 0) {
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Redefine method next.
     * @return array[index], which simple number next.
     */
    @Override
    public Object next() {
        if (hasNext()) {
            return this.arrays[index];
        } else {
            throw new NoSuchElementException();
        }
    }
}
