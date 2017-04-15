package ru.osetsky.tracker.start;

/**
 * Created by koldy on 14.04.2017.
 */
public class StunInput implements Input {
    private String[] answers;
    private int position = 0;
    public StunInput(String[] answers){
        this.answers = answers;
    }
    public String ask(String question){
        return answers[position++];
    }
}
