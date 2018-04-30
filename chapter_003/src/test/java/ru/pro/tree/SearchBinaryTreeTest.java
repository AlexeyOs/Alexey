package ru.pro.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by koldy on 08.02.2018.
 */
public class SearchBinaryTreeTest {

    private SearchBinaryTree<Integer> tree = new SearchBinaryTree<>();
    @Test
    public void whenBinaryElementsInMap() {
        tree.add(8);
        tree.add(5);
        tree.add(10);
        tree.add(1);
        assertThat(tree.find(1), is(true));
        assertThat(tree.find(18), is(false));
    }
    @Test
    public void whenBinaryElementsInMap2() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        assertThat(tree.find(3), is(true));
        assertThat(tree.find(15), is(false));
    }
    @Test
    public void binarySearchTreeTest() {
        List<Integer> expected = Arrays.asList(50, 70, 30, 20, 40, 80, 60);
        List<Integer> result  = new ArrayList<>();

        SearchBinaryTree<Integer> tree = new SearchBinaryTree<>();
        tree.add(50);
        tree.add(70);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(80);
        tree.add(60);

        tree.forEach(result::add);
        assertThat(result, containsInAnyOrder(expected.toArray()));
    }


}
