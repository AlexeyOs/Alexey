package ru.osetsky.tracker.start;

import java.util.Scanner;

/**
 * Created by koldy on 14.04.2017.
 */
public class StunInput extends ConsoleInput {
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
        boolean invalid = true;
        int value = -1;
        /**
         * Operator try for find mistake.
         */
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu. ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again. ");
            }
        } while (invalid);
        return value;
    }
}
