package ru.osetsky.tracker.start;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.osetsky.tracker.models.Item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 14.04.2017.
 */
public class StunInputTest {

    @Test
    public void TestStunInputHowUser() {
        Tracker tracker= new Tracker();
        String[] parametr = {"0", "name", "desc", "6"};
        Input input = new StunInput(parametr);  //создаём StubInput с последовательностью действий
        StartUi sU = new StartUi(input,tracker).init();//   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("name"));// проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    /**
    @Test
    public  void TestHowUserShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("Alex");
        item1.setDescription("coder");
        Item item2 = new Item();
        item2.setName("Petr");
        item2.setDescription("teacher");
        Item[] result = new Item[] {item1,item2};
        assertThat(tracker.getAll(), is(result));
    }
    */
}
