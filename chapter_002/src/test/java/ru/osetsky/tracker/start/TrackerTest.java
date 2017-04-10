package ru.osetsky.tracker.start;

import org.junit.Before;
import org.junit.Test;
import ru.osetsky.tracker.models.Item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 31.03.2017.
 */
public class TrackerTest {
    /**
     * Field is tracker.
     */
    private Tracker tracker;
    /**
     * Field is firstTask.
     */
    private Item firstTask;
    /**
     * Method is initialize.
     */
    @Before
    public final void initialize() {
        tracker = new Tracker();
        firstTask = new Item();
        firstTask.setName("First task");
        firstTask.setDescription("Task for testing");
        tracker.add(firstTask);
    }
    /**
     * Method is whenAddNewItemThenAdded.
     * @throws Exception any
     */
    @Test
    public final void whenAddNewItemThenAdded() throws Exception {
        assertThat(firstTask, is(tracker.findAll()[0]));
    }
    /**
     * Method is whenEditFirstTaskThenChangeOnTmp.
     * @throws Exception any
     */
    @Test
    public final void whenEditFirstTaskThenChangeOnTmp() throws Exception {
        Item tmp = new Item();
        tmp.setName("Edit name");
        tmp.setDescription("Edit description");
        tmp.setId(firstTask.getId());
        tracker.update(tmp);
        assertThat(tmp, is(tracker.findAll()[0]));
    }
}
