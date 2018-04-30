package ru.pro.tree;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 30.01.2018.
 */
public class IsBinaryTreeTest {
    @Test
    public void shouldReturnTrue() {
        Node<Integer> node =  new Node<Integer>(50);
        Tree<Integer> tree = new Tree<Integer>(node);
        tree.add(50, 70);
        tree.add(50, 80);
        tree.add(70, 90);
        tree.add(70, 100);
        tree.add(90, 110);
        tree.add(90, 120);
        tree.add(120, 200);
        tree.add(200, 250);
        tree.add(200, 270);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void shouldReturnFalse() {
        Node<Integer> node =  new Node<Integer>(50);
        Tree<Integer> tree = new Tree<>(node);
        tree.add(50, 70);
        tree.add(50, 80);
        tree.add(70, 90);
        tree.add(70, 100);
        tree.add(90, 110);
        tree.add(90, 120);
        tree.add(100, 180);
        tree.add(100, 190);
        tree.add(100, 290);
        tree.add(180, 200);
        tree.add(180, 210);
        tree.add(190, 211);
        tree.add(190, 215);
        tree.add(190, 217);
        assertThat(tree.isBinary(), is(false));
    }
}
