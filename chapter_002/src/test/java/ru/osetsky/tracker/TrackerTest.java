package ru.osetsky.tracker;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 23.03.2017.
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
        firstTask = new Task("First task", "Task for testing", 1L);
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
        Item tmp = new Task("Edit name", "Edit description", 1L);
        tmp.setId(firstTask.getId());
        tracker.update(tmp);
        assertThat(tmp, is(tracker.findAll()[0]));
    }
}
