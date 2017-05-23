package ru.osetsky.tracker.start;

import java.util.Scanner;

/**
 * Created by koldy on 14.04.2017.
 */
public class StunInput implements Input {
    private String[] answers;
    private int position = 0;
    private Scanner scanner = new Scanner(System.in);
    public StunInput(String[] answers){
        this.answers = answers;
    }
    public String ask(String question){
        return answers[position++];
    }
}
