package ru.osetsky.usersorting;


import java.util.Comparator;
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

    /**
     * Method sortNameLength is sorting name by length.
     * @param list is type User.
     * @return result is type integer.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = Integer.compare(o1.getName().length(), o2.getName().length());
                        return result != 0 ? result : 0;
                    }
                }
        );
        return list;
    }

    /**
     * Method sortByAllFields is sorting by all fields.
     * @param list is type User.
     * @return result1 is integer.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = Integer.compare(o1.getName().length(), o2.getName().length());
                        int result1 = result == 0 ? Integer.compare(o1.getAge(), o2.getAge()) : result;
                        return result1;
                    }
                }
        );
        return list;
    }

}
