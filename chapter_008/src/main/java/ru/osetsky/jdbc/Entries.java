package ru.osetsky.jdbc;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koldy on 06.04.2018.
 */
@XmlRootElement(name = "entries")
@XmlAccessorType (XmlAccessType.FIELD)
public class Entries
{
    @XmlElement(name = "entry")
    private List<Entry> entries = null;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}