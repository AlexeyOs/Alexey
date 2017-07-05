package ru.osetsky.tracker.templates;

import ru.osetsky.tracker.start.Input;
import ru.osetsky.tracker.start.Tracker;
import ru.osetsky.tracker.start.UserAction;

/**
 * Created by koldy on 05.07.2017.
 */
public abstract class BaseAction implements UserAction{
    BaseAction(int key,String name) {
    }
    public abstract String info();
}
