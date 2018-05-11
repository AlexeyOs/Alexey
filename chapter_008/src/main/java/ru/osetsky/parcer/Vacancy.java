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

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vacancy vacancy = (Vacancy) obj;

        if (url != null ? !url.equals(vacancy.url) : vacancy.url != null) {
            return false;
        }
        if (name != null ? !name.equals(vacancy.name) : vacancy.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
