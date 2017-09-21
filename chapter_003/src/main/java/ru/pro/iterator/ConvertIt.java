package ru.pro.iterator;

import java.util.Iterator;

/**
 * Created by koldy on 07.09.2017.
 */
public class ConvertIt implements Iterator<Integer> {
    /**
     * iterator.
     */
    private final Iterator<Iterator<Integer>> iterator;

    /**
     * current iterator.
     */
    private Iterator<Integer> currentIterator;

    /**
     * constructor.
     *
     * @param iterator - initialize object.
     */
    public ConvertIt(Iterator<Iterator<Integer>> iterator) {
        this.iterator = iterator;
    }
    /**
     * Method convert is converting It Iterator<Iterator<Integer>> to Iterator<Integer>.
     * @param it is Iterator<Iterator<Integer>>.
     * @return is Iterator<Integer>.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return this;
    }
    @Override
    public boolean hasNext() {
        boolean result;
        if (currentIterator != null && currentIterator.hasNext()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public Integer next() {
        Integer number = 0;
        this.convert(this.iterator);
        if (currentIterator != null && currentIterator.hasNext()) {
            number = currentIterator.next();
            return number;
        } else {
            currentIterator = iterator.next();
            this.next();
        }
        return number;
    }
}
