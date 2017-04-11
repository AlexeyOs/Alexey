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
        int l = a1.length + a2.length;
        int[] a = new int[l];
            int i = 0;
            for (int j1 = 0; j1 <= a1.length - 1; j1++) {
                a[i] = a1[j1];
                i++;
            }
            for (int j2 = 0; j2 <= a2.length - 1; j2++) {
                a[i] = a2[j2];
                i++;
            }
        boolean sort = false;
        int change;
        OrderLiness proverka = new OrderLiness();
        while (!sort) {
            for (i = 0; i < (a.length - 1); i++) {
                if (a[i] > a[i + 1]) {
                    change = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = change;
                }
            }
            sort = proverka.orderS(a);
        }
        return a;
    }
}
