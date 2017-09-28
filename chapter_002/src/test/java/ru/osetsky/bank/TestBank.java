package ru.osetsky.bank;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 04.08.2017.
 */
public class TestBank {
    /**
     * Method is testStunInputHowUser.
     */
    @Test
    public void testStunInputHowUser() {
        Bank bank = new Bank();
        bank.maxcountpeople(8, "name");
        bank.maxcountpeople(10, "name1");
        bank.maxcountpeople(11, "name");
        bank.maxcountpeople(12, "name2");
        bank.maxcountpeople(13, "name3");
        bank.maxcountpeople(14, "name4");
        long[] result = {5, 14};
        assertThat(bank.maxcountpeople(7, "name7"), is(result));
    }
}
