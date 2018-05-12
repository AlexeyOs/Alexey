package ru.osetsky.exam;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.atan2;
import static java.lang.Math.max;

public class CashMachine {
    /*
     *  Реализован банкомат размена денег. Автомат принимает бумажную купюру и обменивает на монеты.
     *  Метод должен возвращать список всех возможных вариантов размена купюры.
     */
    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    /**
     * Метод сортирует входные монеты.
     */
    public void bubbleSort(int[] arr) {
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * Метод по размену монету на основе жадного алгоритма.
     * @param note Число денег поступившего в метод.
     * @return массив разменных монет
     */

    public List<List<Integer>> exchange(int note) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        bubbleSort(values);
        while (note >= values[0]) {
            if (note >= values[2]) {
                lst.add(values[2]);
                note = note - values[2];
            } else if (note >= values[1]) {
                lst.add(values[1]);
                note = note - values[1];
            } else {
                lst.add(values[0]);
                note = note - values[0];
            }
        }
        list.add(lst);
        return list;
    }
}
