package ru.pro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 11.09.2017.
 */
public class TestUserStore {
    /**
     * Method whenAddToRoleStore is testing class UserStore on method add.
     */
    @Test
    public void whenAddToRoleStore() {
        User us = new User();
        UserStore usStore = new UserStore();
        usStore.add(us);
        SimpleArray<Base> simpleArray = usStore.getSim();
        assertThat(simpleArray.get(0), is(us));
    }
    /**
     * Method whenUpdateToRoleStore is testing class UserStore on methods add and update.
     */
    @Test
    public void whenUpdateToRoleStore() {
        User us1 = new User();
        User us2 = new User();
        UserStore usStore = new UserStore();
        usStore.add(us1);
        usStore.update(us1, us2);
        SimpleArray<Base> sim = usStore.getSim();
        assertThat(sim.get(0), is(us2));
    }
    /**
     * Method whenDeleteToRoleStore is testing class UserStore on methods add and delete.
     */
    @Test
    public void whenDeleteToRoleStore() {
        User us = new User();
        UserStore usStore = new UserStore();
        usStore.delete(us);
        SimpleArray<Base> sim = usStore.getSim();
        assertNull(sim.get(0));
    }
}
