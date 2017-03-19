package ru.osetsky.sort;

/**
 * Created by koldy on 14.03.2017.
 */
public class UnionTwoArrays {
    /**
     * method union two arrays in array.
     * @param a1 array type int
     * @param a2 array type int
     * @return union array.
     */
    public int[] unionTwo(int[] a1, int[] a2) {
        int[] a = new int[a1.length + a2.length];
            int i = 0;
            for (int j1 = 0; j1 <= a1.length; j1++) {
                a[i] = a1[j1];
                i++;
            }
            for (int j2 = 0; j2 <= a2.length; j2++) {
                a[i] = a2[j2];
                i++;
            }
        int sort = 1;
        int change = 1;
        while (sort == a.length) {
            for (i = 0; i < a.length; i++) {
                if (a[i] >= a[i + 1]) {
                    change = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = change;
                }
            }
            for (i = 0; i < a.length; i++) {
                if (a[i] < a[i + 1]) {
                 sort++;
                }
            }
        }

        return a;
    }
}
