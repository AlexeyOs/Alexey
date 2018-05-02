package osetsky.httpprotocol;

import java.util.Date;

/**
 * Created by koldy on 19.04.2018.
 */
public class User {
    private String name = "name";
    private String login = "login";
    private String email = "email";
    private String createDate = "createDate";

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
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getCreateDate() {
        return createDate;
    }
}
