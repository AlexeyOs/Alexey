package ru.osetsky.tracker.start;

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
     * Field is ask.
     * @param question It is inquiry
	 * @param range It is array.
     * @return result of method ask.
     */
    int ask(String question, int[] range);
}
