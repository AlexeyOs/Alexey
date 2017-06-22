package ru.osetsky.tracker.start;

import java.util.Scanner;

/**
 * Created by koldy on 25.03.2017.
 */
public class ConsoleInput implements Input {
    /**
     * Field is private for scanning information.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Method is ask.
     * @param question IT is inquiry.
     * @return information.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
	/**
     * Method is ask.
     * @param question IT is inquiry
	 * @param range It is array type integer.
     * @return information.
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
            return key;
        } else {
            throw new MenuOutException("out of menu range. ");
        }
    }
	/**
	 * Method is comand.
     * @return information.
     */
    public int comand() {
        return scanner.nextInt();
    }
}
