package ru.pro.map;

import org.junit.Test;
import ru.pro.referencebook.ReferenceBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 25.10.2017.
 */
public class TestReferenceBook {
    private ReferenceBook<String, String> hList = new ReferenceBook<>();

    private String key1 = "testKey1";

    private String key2 = "testKey2";

    private String value1 = "testValue1";

    //private String value2 = "testValue2";

    @Test
    public void whenInsertKeyAndValueThenTheseKeyAndValueAreInHashList() {
        this.hList.insert(key1, value1);
        String expectedValue = this.value1;
        String resultValue = this.hList.get(key1);
        assertThat(resultValue, is(expectedValue));
    }

    @Test
    public void whenInsertNullThenGetReturnsNull() {
        this.hList.insert(null, this.value1);
        String expectedValue = this.value1;
        String resultValue = this.hList.get(null);
        assertThat(resultValue, is(expectedValue));
    }

    @Test
    public void whenGetNonexistingKeyThenReturnsNull() {
        String expectedValue = null;
        String resultValue = this.hList.get("Zoo");
        assertThat(resultValue, is(expectedValue));
    }
}
