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
     * @param children - user name
     * @param birthday - Date birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * @param name - user name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param children -count children.
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * @param birthday -Date birthday.
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    /**
     * @return user name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return count children.
     */
    public int getChildren() {
        return this.children;
    }

    /**
     * @return date birthday.
     */
    public Calendar getBirthday() {
        return this.birthday;
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
        if (name != null && birthday != null ? !name.equals(user.name) || !birthday.equals(user.birthday) : user.name != null && user.birthday != null) {
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
