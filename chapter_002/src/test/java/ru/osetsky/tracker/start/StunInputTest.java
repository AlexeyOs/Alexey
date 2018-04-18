package ru.osetsky.tracker.start;
import org.junit.Test;

import java.sql.SQLException;

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
    public void testStunInputHowUser() throws SQLException {
        Tracker tracker = new Tracker();
        String[] parametr = {"name", "desc"};
        Input input = new StunInput(parametr);  //создаём StubInput с последовательносeтью действий
        //StartUi sU = new StartUi(input, tracker).init(); // создаём StartUI и вызываем метод init()
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        menu.select(0);
        assertThat(tracker.getAll().get(0).getName(), is("name"));  // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
	/**
	 * Method is testHowUserAddItem.
	 */
    @Test
    public  void testHowUserAddItem() throws SQLException {
        Tracker tracker = new Tracker();
        String[] parametr = {"Alex", "coder"};
        Input input = new StunInput(parametr);
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        menu.select(0);
        assertThat(tracker.getAll().get(0).getDescription(), is("coder"));
    }
	/**
	 * Method is testHowUserAddAndDeleteItem.
	 */
    @Test
    public  void testHowUserAddAndDeleteItem() throws SQLException {
        Tracker tracker = new Tracker();
        String[] parametr = {"Lala", "coder"};
        Input input = new StunInput(parametr);
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        menu.select(0);
        menu.select(3);
        assertThat(tracker.getAll().get(0).getDescription(), is(nullValue()));
    }
    /**
     * Method is testHowUserAddAndDeleteItem2.
     */
    @Test
    public  void testHowUserAddAndDeleteItem2() throws SQLException {
        Tracker tracker = new Tracker();
        String[] parametr = {"Petr", "teacher"};
        Input input = new StunInput(parametr);
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        menu.select(0);
        menu.select(3);
        assertThat(tracker.getAll().get(0).getDescription(), is(nullValue()));
    }
    /**
     * Method is testHowUserInputIncorrectValue.
     */
    @Test(expected = NumberFormatException.class)
    public void testHowUserInputIncorrectValue() throws SQLException {
        Tracker tracker = new Tracker();
        Input input = new StunInput(new String[] {"1", "name", "desc"});
        new StartUi(input, tracker).init();
    }
    /**
     * Method is testHowUserInputIncorrectValue2.
     */
    @Test(expected = MenuOutException.class)
    public void testHowUserInputIncorrectValue2() throws SQLException {
        Tracker tracker = new Tracker();
        Input input = new StunInput(new String[] {"7", "name", "desc"});
        new StartUi(input, tracker).init();
    }

}
