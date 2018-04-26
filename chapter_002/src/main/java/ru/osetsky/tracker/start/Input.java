package ru.osetsky.tracker.start;

/**
 * Created by koldy on 25.03.2017.
 */
public interface Input {
    /**
     * Поле запрашивает входные данные.
     * @param question Входной запрос.
     * @return result результат возвращающий на входные данные.
     */
    String ask(String question);
  /**
     * Поле запрашивает цифру выбор меню.
     * @param question Входной запрос
	 * @param range Пункты меню.
     * @return result результат возвращающий на входные данные.
     */
    int ask(String question, int[] range);
}
