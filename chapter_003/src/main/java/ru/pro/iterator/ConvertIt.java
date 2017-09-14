package ru.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by koldy on 07.09.2017.
 */
class ConvertIt {
    /**
     * Method convert is converting It Iterator<Iterator<Integer>> to Iterator<Integer>.
     * @param it is Iterator<Iterator<Integer>>.
     * @return is Iterator<Integer>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> currentIterator = null;

            @Override
            public boolean hasNext() {
                if (currentIterator == null) {
                    return false;
                }
                if (currentIterator.hasNext()) {
                    return true;
                }
                return currentIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (currentIterator == null) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();
            }
        };
    }

}
