package ru.osetsky;

import java.util.HashMap;
import java.util.List;

/**
 * Created by koldy on 12.08.2017.
 */
public class UserConvert {
    /**
     * This method is add users in HashMap.
     * @param list is List<User>.
     * @return is HashMap<Integer, User>.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> h = new HashMap<Integer, User>();
        for (User user: list) {
            h.put(user.getId(), user);
        }
        return h;
    }
}