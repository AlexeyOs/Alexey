package ru.osetsky.tracker.start;

import java.util.Scanner;

/**
 * Created by koldy on 14.04.2017.
 */
public class StunInput implements Input {
	/**
     * Field is answers.
     */
    private String[] answers;
	/**
     * Field is position.
     */
    private int position = 0;
	/**
     * Field is scanner.
     */
    private Scanner scanner = new Scanner(System.in);
	/**
     * Method is StunInput.
	 * @param answers It is String array.
     */
    public StunInput(String[] answers) {
        this.answers = answers;
    }
	/**
     * Method ask.
     * @param question It is String.
	 * @return answers It is integer.
     */
    public String ask(String question) {
        return answers[position++];
    }
	/**
     * Method ask.
     * @param question It is String
	 * @param range It is array type integer.
	 * @return answers It is integer.
     */
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Unsupported operation");
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
