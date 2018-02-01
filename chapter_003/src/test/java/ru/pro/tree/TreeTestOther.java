package ru.pro.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 30.01.2018.
 */
public class TreeTestOther {
    private List<Integer> expected = Arrays.asList(50, 60, 70, 10, 5, 80, 100, 150);
    private List<Integer> result = new ArrayList<>();
    Node<Integer> node =  new Node<Integer>(50);
    private Tree<Integer> tree = new Tree<Integer>(node);


    @Before
    public void setUp(){
        tree.add(50, 60);
        tree.add(50, 70);
        tree.add(60, 10);
        tree.add(60, 5);
        tree.add(60, 70);
        tree.add(70, 80);
        tree.add(70, 100);
        tree.add(100, 150);
        tree.add(100, 10);
        tree.add(50, 150);
        tree.forEach(result::add);
    }

    @Test
    public void resultShouldContainExpectedValuesAndOny () {
        assertThat(result, containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void printToCompare(){
        printResultAndExpected();
    }

    public void printResultAndExpected () {
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());

        System.out.println("expected");
        expected.forEach((i) -> System.out.print(i + " "));
        System.out.println("\nresult");
        result.forEach((i) -> System.out.print(i + " "));
    }
}
