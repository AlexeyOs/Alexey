package ru.osetsky.tracker.start;

import org.junit.Test;
import ru.osetsky.tracker.models.Item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 14.04.2017.
 */
public class StunInputTest {
	/**
	 * Method is testStunInputHowUser.
	 */
    @Test
    public void testStunInputHowUser() {
        Tracker tracker = new Tracker();
        String[] parametr = {"0", "name", "desc", "6"};
        Input input = new StunInput(parametr);  //создаём StubInput с последовательностью действий
        StartUi sU = new StartUi(input, tracker).init(); // создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
	/**
	 * Method is testHowUserAddItem.
	 */
    @Test
    public  void testHowUserAddItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("Alex");
        item1.setDescription("coder");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("Petr");
        item2.setDescription("teacher");
        tracker.add(item2);
        Item[] result = new Item[] {item1, item2};
        assertThat(tracker.getAll(), is(result));
    }
	/**
	 * Method is testHowUserFindByNameItem.
	 */
    @Test
    public  void testHowUserFindByNameItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("Alex");
        item1.setDescription("coder");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("Petr");
        item2.setDescription("teacher");
        tracker.add(item2);
        assertThat(tracker.findByName("Alex"), is(item1));
    }
	/**
	 * Method is testHowUserFindByIdItem.
	 */
    @Test
    public  void testHowUserFindByIdItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("Alex");
        item1.setDescription("coder");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("Petr");
        item2.setDescription("teacher");
        tracker.add(item2);
        String inputId = item1.getId();
        assertThat(tracker.findById(inputId), is(item1));
    }

}
