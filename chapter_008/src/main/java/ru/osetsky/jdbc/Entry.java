package ru.osetsky.jdbc;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by koldy on 05.04.2018.
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    int field;

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }


}