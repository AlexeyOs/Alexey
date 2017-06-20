package ru.osetsky.tracker.start;

/**
 * Created by koldy on 16.06.2017.
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracke);

    String info();
}
