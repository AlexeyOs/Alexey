package ru.pro.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


/**
 * Created by koldy on 15.10.2017.
 */
public class TestUser {
    /**
     * Object map.
     */
    private Map<User, String> map = new HashMap<>();
    /**
     * when Compare Two Objects User.
     */
    @Test
    public void whenCompareTwoObjectsUser() {
        Calendar birthday = new GregorianCalendar(1997, 01, 05);
        User user1 = new User("Vika", 0, birthday);
        User user2 = new User("Vika", 0, birthday);
        map.put(user1, "123");
        map.put(user2, "124");
        Iterator<Map.Entry<User, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<User, String>  changer = iterator.next();
            User userName = changer.getKey();
            String userID = changer.getValue();
            System.out.println(userName + ":" + userID);
        }
    }
}
