package ru.osetsky;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by koldy on 09.07.2017.
 */
public class ConvertList {
    /**
     * Method List is transformation Array to ArrayList.
     * @param array is int[][].
     * @return result.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }

    /**
     * Method List is transformation List to Array.
     * @param list is tyoe List<integer>
     * @param rows is type integer.
     * @return result.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iter = list.iterator();
        int stolbec;
        if (list.size() % rows == 0) {
            stolbec = list.size() / rows;
        } else {
            stolbec = (int) (list.size() / rows) + 1;
        }
        int result[][] = new int[rows][stolbec];
        for (int i = 0; i < stolbec; i++) {
            for (int j = 0; j < rows; j++) {
                if (iter.hasNext()) {
                    result[i][j] = iter.next();
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

}
