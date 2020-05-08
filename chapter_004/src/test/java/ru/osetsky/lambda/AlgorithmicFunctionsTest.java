package ru.osetsky.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlgorithmicFunctionsTest {
    Function<Double, Double> function;

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        List<Double> result = diapason(5, 8, x -> x *x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunctionThenLinearResults() {
        List<Double> result = diapason(5, 8, x -> 2 *x);
        List<Double> expected = Arrays.asList(10D, 12D, 14D);
        assertThat(result, is(expected));
    }
}
