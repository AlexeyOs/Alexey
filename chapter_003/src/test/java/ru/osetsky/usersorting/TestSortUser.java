package ru.osetsky.usersorting;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 26.08.2017.
 */
public class TestSortUser {
    /**
     * Method is whenUsingComparable.
     */
    @Test
    public void whenUsingComparable() {
        Set<User> tree = new TreeSet<User>();
        User us1 = new User(19, "Alexey");
        User us2 = new User(20, "Natalia");
        User us3 = new User(22, "Victoria");
        tree.add(us1);
        tree.add(us2);
        tree.add(us3);
        Set<User> users = new TreeSet<User>();
        users.addAll(
                Arrays.asList(
                        new User(20, "Natalia"),
                        new User(19, "Alexey"),
                        new User(22, "Victoria")
                )
        );
        assertThat(users, is(tree));
    }

    /**
     * Method is whenSortingLengthName.
     */
    @Test
    public void whenSortingLengthName() {
        SortUser s = new SortUser();
        List<User> tree = new ArrayList<User>();
        User us1 = new User(19, "Alexey");
        User us2 = new User(19, "Alex");
        User us3 = new User(20, "Natalia");
        User us4 = new User(22, "Victoria");
        tree.add(us2);
        tree.add(us1);
        tree.add(us3);
        tree.add(us4);
        List<User> users = new ArrayList<User>();
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);
        assertThat(s.sortNameLength(users), is(tree));
    }
    /**
     * Method is whenSortingtByAllFields.
     */
    @Test
    public void whenSortingtByAllFields() {
        SortUser s = new SortUser();
        List<User> tree = new ArrayList<User>();
        User us1 = new User(19, "Alexey");
        User us2 = new User(20, "Natalia");
        User us3 = new User(21, "Natalia");
        User us4 = new User(22, "Victoria");
        tree.add(us1);
        tree.add(us2);
        tree.add(us3);
        tree.add(us4);
        List<User> users = new ArrayList<User>();
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);
        assertThat(s.sortByAllFields(users), is(tree));
    }
}
