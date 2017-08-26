package ru.osetsky.userconversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 19.08.2017.
 */
public class TestUserConvert {

    /**
     * Method is testUserConvertListToMap.
     */
    @Test
    public void testUserConvertListToMap() {
        UserConvert user = new UserConvert();
        HashMap<Integer, User> h;
        List<User> list = new ArrayList<User>();
        User user1 = new User(1, "Alexey", "Krasnodar");
        User user2 = new User(2, "Vika", "Sochi");
        User user3 = new User(3, "Natash", "Kazan");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        h = user.process(list);
        boolean fact = false;
        boolean except = true;
        if (h.containsKey(1) && h.containsKey(2) && h.containsKey(3)) {
            fact = true;
        }
        assertThat(fact, is(except));

    }

}
