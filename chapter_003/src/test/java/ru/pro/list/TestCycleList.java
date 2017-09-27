package ru.pro.list;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by koldy on 27.09.2017.
 */
public class TestCycleList {
    /**
     * class object.
     */
    private CycleList<String> list;


    /**
     * test method hasCycle, if list have cycle, then return true.
     */
    @Test
    public void whenCallHasCycleAndListIsACycleThenReturnTrue() {
        this.list = new CycleList<>();
        this.createCycleList();
        assertTrue(list.hasCycle(list.getFirstNode()));
    }

    /**
     * test method hasCycle, if list have no cycle, then return false.
     */
    @Test
    public void whenCallHasCycleAndListIsANoCycleThenReturnTrue() {
        this.list = new CycleList<>();
        this.createNoCycleList();
        assertFalse(list.hasCycle(list.getFirstNode()));
    }

    /**
     * create list with out no cycle.
     */
    public void createNoCycleList() {
        this.list = new CycleList<>();
        this.list.addNoCycle("1111");
        this.list.addNoCycle("2222");
        this.list.addNoCycle("3333");
        this.list.addNoCycle("4444");
    }
    /**
     * create list with cycle.
     */
    public void createCycleList() {
        this.list.addToWithCycle("1111");
        this.list.addToWithCycle("2222");
        this.list.addToWithCycle("3333");
        this.list.addToWithCycle("4444");
    }
}
