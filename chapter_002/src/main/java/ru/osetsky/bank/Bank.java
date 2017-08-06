package ru.osetsky.bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by koldy on 22.07.2017.
 */
public class Bank {
    /**
     *  В течении дня в банк заходят люди, у каждого человека есть время захода в банк и время выхода.
     * Всего за день у банка было N посетителей. Банк работает с 8:00 до 20:00.
     * Человек посещает банк только один раз за день.
     * Написать программу, которая определяет периоды времени,
     * когда в банке было максимальное количество посетителей.
    */

    /**
     * Массив содержащий имена клиентов.
     */
    private ArrayList<String> names = new ArrayList<String>();
    /**
     * Массив содержащий время прихода клиентов.
     */
    private List<Long> timeEntry = new LinkedList<Long>();
    /**
     * Количество человек.
     */
    private int countPeople = 0;
    /**
     * количество человек на текущий момент в банке.
     */
    private int countCurrent = 0;
    /**
     * Максимальное количество человек, данная переменная необходима для определения максимума.
     */
    private long[] countCurrentMax = {0, 0};
    /**
     * Булевская переменная для того чтобы вычитать человека из количества людей находящихся в текущий момент в банке.
     */
    private boolean delete = false;

    /**
     * @param timeParam передает время входа или выхода клиента.
     * @param name передает имя клиента.
     * @return максимальное количество человек находившихся в банке одновременно и определяет время максимума
     * людей в банке по последнему вошедшему.
     */
    public long[] maxcountpeople(long timeParam, String name) {
        if (countPeople != 0) {
            for (int i = 0; i < countPeople; i++) {
                if (name.equals(names.get(i))) {
                  delete = true;
                  if (timeEntry.indexOf(timeParam) != -1) {
                      timeEntry.remove(timeEntry.indexOf(timeParam));
                  }
                }
            }
        }
        if (delete) {
            countCurrent--;
            delete = false;
            System.out.println(countCurrent);
        } else {
                timeEntry.add(timeParam);
                names.add(countPeople, name);
                countPeople++;
                countCurrent++;
            }
        if (countCurrent > countCurrentMax[0]) {
            countCurrentMax[0] = countCurrent;
            for (int i = 0; i < countPeople; i++) {
                if (timeParam > timeEntry.get(i)) {
                    countCurrentMax[1] = timeParam;
                }
            }
        }

       return countCurrentMax;
    }


}
