package ru.osetsky.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class SearchAttTest {

    List<Attachment> list = new ArrayList<>();

    @Before
    public void beforeTest() {
        list.add(new Attachment("One",123));
        list.add(new Attachment("Two",2));
        list.add(new Attachment("Testbug",130));
        list.add(new Attachment("bug",130));
    }

    @Test
    public void filterSize() {
        assertThat (SearchAtt.filterSize(list).size(),is(3));
    }

    @Test
    public void filterName() {
        assertThat (SearchAtt.filterName(list).size(),is(2));
    }
}
