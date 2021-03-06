package ru.osetsky.models;


/**
 * Created by koldy on 19.04.2018.
 */
public class User {
    private String id;
    private String name;
    private String login;
    private String email;
    private String password;
    private int role;
    private String createDate;
    private String country;
    private String city;

    public User(String id,
                String name,
                String login,
                String email,
                String password,
                int role,
                String createDate,
                String country,
                String city) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
        this.country = country;
        this.city = city;
    }

    public User(String name, String login, String email, String password, int role, String createDate, String country, String city) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
        this.country = country;
        this.city = city;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public int getRole() {
        return role;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getCreateDate() {
        return createDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
