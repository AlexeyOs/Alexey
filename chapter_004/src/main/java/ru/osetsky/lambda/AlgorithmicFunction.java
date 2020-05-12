package ru.osetsky.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AlgorithmicFunction {
    Function<Double, Double> function;

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }
}
