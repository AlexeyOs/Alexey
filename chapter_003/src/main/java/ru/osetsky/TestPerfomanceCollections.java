package ru.osetsky;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by koldy on 08.07.2017.
 */
public class TestPerfomanceCollections {
    /**
     * Method add is public.
     * @param collection is String
     * @param amount type integer.
     * @return value.
     */
    public long add(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add("1" + i);
        }
        long result = System.currentTimeMillis() - start;
        return result;
    }
    /**
     * Method delete is public.
     * @param collection is String
     * @param amount is array type integer.
     * @return value.
     */
    public long delete(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        Iterator iter = collection.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        long result = System.currentTimeMillis() - start;
        return result;
    }
}
