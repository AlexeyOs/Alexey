package ru.osetsky.lambda;

import java.util.Comparator;

public class StringComparison {

    public Comparator<String> compareStringByDefault() {
        return (left, right) -> {
            System.out.println("compare - left " + left + " : right " + right);
            return left.compareTo(right);
        };
    }

    public Comparator<String> compareStringByDescendingLength(){
        return (left, right)-> {
            System.out.println("compare - right.length() " + right.length() + " : left.length()" + left.length());
            return right.length() - left.length();
        };
    }
}
