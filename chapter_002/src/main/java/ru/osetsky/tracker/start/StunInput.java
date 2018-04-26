package ru.osetsky.tracker.start;

import java.util.Scanner;

/**
 * Created by koldy on 14.04.2017.
 */
public class StunInput implements Input {
	/**
     * Поле-массив с ответами.
     */
    private String[] answers;
	/**
     * Поле номера меню.
     */
    private int position = 0;
	/**
     * Поле отвечающее за считывание входных данных.
     */
    private Scanner scanner = new Scanner(System.in);
	/**
     * Конструктор.
	 * @param answers Массив содержащий пункты меню.
     */
    public StunInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Поле запрашивает входные данные.
     * @param question Входной запрос.
     * @return result результат возвращающий на входные данные.
     */
    public String ask(String question) {
        return answers[position++];
    }
    /**
     * Поле запрашивает цифру выбор меню.
     * @param question Входной запрос
     * @param range Пункты меню.
     * @return result результат возвращающий на входные данные.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return  key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
