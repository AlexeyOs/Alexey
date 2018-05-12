package ru.osetsky.exam;

import org.junit.Test;
import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashMachineTest {
    @Test
    public void unchange() {
        CashMachine machine = new CashMachine(new int[] {1, 5, 10});
        List<List<Integer>> result = machine.exchange(1);
        assertThat(result, is(singletonList(singletonList(1))));
    }

    @Test
    public void five() {
        CashMachine machine = new CashMachine(new int[] {1, 5, 10});
        List<List<Integer>> result = machine.exchange(5);
        assertThat(result, is(
                asList(
                        asList(5)
                )
        ));
    }

    @Test
    public void change() {
        CashMachine machine = new CashMachine(new int[] {10, 5, 1});
        List<List<Integer>> result = machine.exchange(10);
        assertThat(
                result, is(
                        asList(
                                singletonList(10)
                        )
                )
        );
    }
}