package ru.osetsky.parcer;

import java.util.Calendar;

/**
 * Created by koldy on 23.04.2018.
 */
public class Vacancy {
    private String name;
    private String url;

    public Vacancy(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
