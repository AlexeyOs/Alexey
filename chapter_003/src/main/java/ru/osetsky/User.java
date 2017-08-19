package ru.osetsky;

/**
 * Created by koldy on 12.08.2017.
 */
public class User {
    /**
     * Field id is type integer.
     */
    private int id;
    /**
     * Field name is type String.
     */
    private String name;
    /**
     * Field city is type String.
     */
    private String city;

    /**
     * Constructor User is public.
     * @param id is type Integer.
     * @param name is type String.
     * @param city is type String.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Method is getId integer.
     * @return id is integer.
     */
    public int getId() {
        return this.id;
    }
}
