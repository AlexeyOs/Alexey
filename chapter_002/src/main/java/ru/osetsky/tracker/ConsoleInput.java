package ru.osetsky.tracker;

import java.util.Scanner;

/**
 * Created by koldy on 25.03.2017.
 */
public class ConsoleInput {
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
}
