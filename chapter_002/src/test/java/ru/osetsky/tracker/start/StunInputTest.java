package ru.osetsky.tracker.start;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;

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
        Input input = new StunInput(parametr);  //создаём StubInput с последовательносeтью действий
        StartUi sU = new StartUi(input, tracker).init(); // создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
	/**
	 * Method is testHowUserAddItem.
	 */
    @Test
    public  void testHowUserAddItem() {
        Tracker tracker = new Tracker();
        String[] parametr = {"0", "Alex", "coder", "6"};
        Input input = new StunInput(parametr);
        StartUi sAdd = new StartUi(input, tracker).init();
        assertThat(tracker.getAll()[0].getDescription(), is("coder"));
    }
	/**
	 * Method is testHowUserAddAndDeleteItem.
	 */
    @Test
    public  void testHowUserAddAndDeleteItem() {
        Tracker tracker = new Tracker();
        String[] parametr = {"0", "Lala", "coder", "3", "6"};
        Input input = new StunInput(parametr);
        StartUi sDelete = new StartUi(input, tracker).init();
        assertThat(tracker.getAll()[0].getDescription(), is(nullValue()));
    }
    /**
     * Method is testHowUserAddAndDeleteItem2.
     */
    @Test
    public  void testHowUserAddAndDeleteItem2() {
        Tracker tracker = new Tracker();
        String[] parametr = {"0", "Petr", "teacher", "3", "6"};
        Input input = new StunInput(parametr);
        StartUi sAdd = new StartUi(input, tracker).init();
        assertThat(tracker.getAll()[0].getDescription(), is(nullValue()));
    }

}
