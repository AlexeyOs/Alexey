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
        return scanner.next();
    }
	/**
	 * Method is comand.
     * @return information.
     */
    public int comand() {
        return scanner.nextInt();
    }
}
