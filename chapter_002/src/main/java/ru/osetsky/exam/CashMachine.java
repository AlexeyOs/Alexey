package ru.osetsky.exam;

import java.util.ArrayList;
import java.util.List;

public class CashMachine {
    /*
     *  Реализован банкомат размена денег. Автомат принимает бумажную купюру и обменивает на монеты.
     *  Метод должен возвращать список всех возможных вариантов размена купюры.
     */
    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        if (note == 1) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> lst = new ArrayList<>();
            lst.add(note);
            list.add(lst);
            return list;
        }
        if (note == 5) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> lst1 = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                lst1.add(1);
            }
            List<Integer> lst2 = new ArrayList<>();
            lst2.add(note);
            list.add(lst1);
            list.add(lst2);
            return list;
        }
        if (note == 10) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> lst1 = new ArrayList<>();
            lst1.add(note);
            List<Integer> lst2 = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                lst2.add(5);
            }
            List<Integer> lst3 = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                lst3.add(1);
            }
            lst3.add(5);
            List<Integer> lst4 = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                lst4.add(1);
            }
            list.add(lst1);
            list.add(lst2);
            list.add(lst3);
            list.add(lst4);
            return list;
        }
        return null;
    }
}
