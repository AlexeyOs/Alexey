package ru.osetsky.monitorsynchronizy;

import org.junit.Test;

/**
 * Created by koldy on 15.01.2018.
 */
public class UserStoraTest {
    @Test
    public void whenAddAndTransferAmountForUserStore() {
        UserStore stoge = new UserStore();
        stoge.add(new User(1, 100));
        stoge.add(new User(2, 200));
        stoge.transfer(1, 2, 50);
    }
}
