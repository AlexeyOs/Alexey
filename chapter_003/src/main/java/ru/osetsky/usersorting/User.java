package ru.osetsky.usersorting;

/**
 * Created by koldy on 26.08.2017.
 */
public class User implements Comparable {
    /**
     * Field age is type integer.
     */
    private int age;
    /**
     * Field name is type String.
     */
    private String name;

    /**
     * Constructor User.
     * @param age is type Integer.
     * @param name is type String.
     */
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /**
     * @return age is type Integer.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Method compareTo.
     * @param o is Object.
     * @return difference age.
     */
    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return this.age - user.getAge();
    }
}
