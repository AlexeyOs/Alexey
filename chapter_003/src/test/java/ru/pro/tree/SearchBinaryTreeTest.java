package ru.pro.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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


}
