package ru.osetsky.lambda;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchAtt {

    public static Predicate<Attachment> filterSize() {
        return p -> p.getSize() > 100;
    }

    public static Predicate<Attachment> filterName() {
        return p -> p.getName().contains("bug");
    }

    public static List<Attachment> filter(List<Attachment> list,
                                          Predicate<Attachment> predicate) {
        return list.stream()
                .filter( predicate )
                .collect(Collectors.<Attachment>toList());
    }

}