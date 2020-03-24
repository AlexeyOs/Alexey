package ru.osetsky.lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate predicate = attach -> ((Attachment) attach).getSize() > 100;
        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate predicate = attach -> ((Attachment) attach).getName().contains("bug");
        return filter(list, predicate);
    }

    public static List<Attachment> filter(List<Attachment> list,
                                          Predicate predicate) {
        List<Attachment> result = new ArrayList<Attachment>();
        for (Attachment element: list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

}