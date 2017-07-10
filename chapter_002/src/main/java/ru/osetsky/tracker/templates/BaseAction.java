package ru.osetsky.tracker.templates;

import ru.osetsky.tracker.start.UserAction;

/**
 * Created by koldy on 05.07.2017.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Field is description.
     */
    private String description;
    /**
     * Field is key.
     */
    private int key;
    /**
     * Method BaseAction is public.
     * @param key type integer
     * @param name type String.
     */
    public BaseAction(int key, String name) {
        this.key = key;
        this.description = name;
    }
    /**
     * Method key is public.
     * @return key type integer.
     */
    public int key(){
        return key;
    }
    /**
     * Method info is public.
     * @return String key and description.
     */
    public String info() {
        return String.format("%s. %s", this.key, this.description);
    }
}
