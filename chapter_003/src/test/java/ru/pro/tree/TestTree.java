package ru.pro.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 13.11.2017.
 */
public class TestTree {

    private Tree<String> treeTest;


    private Iterator iteratorTest;

    private Node<String> rootTest;


    @Before
    public void setUp() {
        rootTest = new Node<>("root");
        treeTest = new Tree<>(rootTest);

        iteratorTest = treeTest.iterator();

        treeTest.add("root", "one");
        treeTest.add("root", "two");
    }


    @Test
    public void whenCreateTreeThanResultRootElement() {
        String result = treeTest.iterator().next();
        assertThat(result, is("root"));
    }

    @Test
    public void whenThereIsNodeWith2ChildsThenIsNotBinary() {
        rootTest = new Node<>("1");
        Tree<String> tree = new Tree<>(rootTest);
        tree.add("1", "11");
        tree.add("11", "111");
        tree.add("11", "112");
        tree.add("1", "12");
        tree.add("12", "121");
        tree.add("12", "122");
        tree.add("12", "123");
        assertThat(tree.isBinary(), is(false));
    }

}
