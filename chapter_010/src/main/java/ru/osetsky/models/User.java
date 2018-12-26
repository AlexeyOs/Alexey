package ru.osetsky.models;


import java.sql.Timestamp;

/**
 * Created by koldy on 1.04.2018.
 */
public class User {
    private String id;
    private String login;
    private String password;
    private Timestamp created;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setCreated(Timestamp created) {
        this.created = created;
    }
    public Timestamp getCreated() {
        return created;
    }
}
