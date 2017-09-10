package ru.pro.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by koldy on 07.09.2017.
 */
public class ConvertIt {
    /**
     * Method convert is converting It Iterator<Iterator<Integer>> to Iterator<Integer>.
     * @param it is Iterator<Iterator<Integer>>.
     * @return is Iterator<Integer>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        ArrayList list = new ArrayList();
        while (it.hasNext()) {
            Iterator<Integer> iter = it.next();
            while (iter.hasNext()) {
                list.add(iter.next());
            }
        }
        return list.iterator();
    };

//    @Override
//    public boolean hasNext() {
//        return false;
//    }
//
//    @Override
//    public Object next() {
//        return null;
//    }

}
