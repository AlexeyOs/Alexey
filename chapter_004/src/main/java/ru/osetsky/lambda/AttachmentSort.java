package ru.osetsky.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator comparatorSize =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparatorSize);
        System.out.println(attachments);
        // Здесь создайте компаратор на основании анонимного класса.
        Comparator comparatorName =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment attachment1 = (Attachment) o1;
                Attachment attachment2 = (Attachment) o2;
                return attachment1.getName().compareTo(attachment2.getName());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}