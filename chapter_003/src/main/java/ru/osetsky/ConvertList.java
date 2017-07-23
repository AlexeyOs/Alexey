package ru.osetsky;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by koldy on 09.07.2017.
 */
public class ConvertList {

    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }
    public int[][] toArray (List<Integer> list, int rows) {
        int arr[][]= new int[2][3];
        return arr;
    }
}
