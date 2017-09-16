package ru.pro.iterator;

import java.util.Iterator;

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
    private int index = 0;
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
        return this.getPrimeIndex() != -1;
    }
    /**
     * Get next prime number.
     * @return next prime number.
     */
    @Override
    public Object next() {
        this.index = this.getPrimeIndex();
        Object result = this.arrays[this.index++];
        return result;
    }

    /**
     * The method checks this prime number.
     * @param num - number.
     * @return - true or false.
     */
    private boolean isPrimeNumber(int num) {
        boolean result = true;
        if (num == 0 || num == 1) {
            result = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * Will find the index of a prime number.
     * @return - prime index.
     */
    private int getPrimeIndex() {
        int result = -1;
        for (int i = this.index; i < this.arrays.length; i++) {
            if (this.isPrimeNumber(this.arrays[i])) {
                result = i;
                break;
            }
        }
        return result;
    }
}
