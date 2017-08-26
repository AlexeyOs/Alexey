package ru.osetsky.usersorting;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by koldy on 26.08.2017.
 */
public class SortUser {

    /**
     * Method sort is type Set<User>.
     * @param list is User.
     * @return result.
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<User>();
        result.addAll(list);
        return result;
    }

}
