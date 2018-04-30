package ru.osetsky.nonblockingalgoritm;

/**
 * Created by koldy on 15.03.2018.
 */
public class User {

    private int key;
    private String value;
    private int version;
    public User(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public int getKey() {
        return key;
    }
    public int getVersion() {
        return version;
    }
    public String getValue() {
        return value;
    }
}
