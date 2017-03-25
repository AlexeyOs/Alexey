package ru.osetsky.tracker;

/**
 * Created by koldy on 25.03.2017.
 */
public interface Input {
    /**
     * Field is ask.
     * @param question It is inquiry.
     * @return result of method ask.
     */
    String ask(String question);

    /**
     * Method ask.
     * @param question It is inquiry.
     * @param range .
     * @return .
     */
    int ask(String question, int[] range);
}
