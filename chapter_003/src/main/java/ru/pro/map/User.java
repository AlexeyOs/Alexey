package ru.pro.map;

import java.util.Calendar;

/**
 * Created by koldy on 28.09.2017.
 */
public class User {
    /**
     * user name.
     */
    private String name;
    /**
     * count children.
     */
    private int children;
    /**
     * Date birthday.
     */
    private Calendar birthday;

    /**
     * @param name - user name.
     * @param children - count children.
     * @param birthday - Date birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * @param o - object for check.
     * @return boolean result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        if (name != null ? name.equals(user.name) : user.name != null) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? name.hashCode() : 0);
        return result;
    }
}
