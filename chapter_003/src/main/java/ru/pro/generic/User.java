package ru.pro.generic;

/**
 * Created by koldy on 08.09.2017.
 */
public class User extends Base {
    /**
     * Field id is String.
     */
    private String id;


    @Override
    void setId(String id) {
        this.id = id;
    }

    @Override
    String getId() {
        return this.id;
    }
}
