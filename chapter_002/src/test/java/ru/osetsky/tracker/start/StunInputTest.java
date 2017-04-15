package ru.osetsky.tracker.start;

import org.junit.Test;

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
}
