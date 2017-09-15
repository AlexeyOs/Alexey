package ru.pro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 11.09.2017.
 */
public class TestRoleStore {
    /**
     * Method whenAddToRoleStore is testing class RoleStore on method add.
     */
    @Test
    public void whenAddToRoleStore() {
        Role us = new Role();
        RoleStore usStore = new RoleStore();
        usStore.add(us);
        SimpleArray<Base> sim = usStore.getSim();
        assertThat(sim.get(0), is(us));
    }
    /**
     * Method whenUpdateToRoleStore is testing class RoleStore on methods add and update.
     */
    @Test
    public void whenUpdateToRoleStore() {
        Role us1 = new Role();
        Role us2 = new Role();
        RoleStore usStore = new RoleStore();
        usStore.add(us1);
        usStore.update(0, us2);
        SimpleArray<Base> sim = usStore.getSim();
        assertThat(sim.get(0), is(us2));
    }
    /**
     * Method whenDeleteToRoleStore is testing class RoleStore on methods add and delete.
     */
    @Test
    public void whenDeleteToRoleStore() {
        Role us = new Role();
        RoleStore usStore = new RoleStore();
        usStore.add(us);
        usStore.delete(0);
        SimpleArray<Base> sim = usStore.getSim();
        assertNull(sim.get(0));
    }
}
