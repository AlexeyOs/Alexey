package ru.osetsky.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {

    List<Student> students = new ArrayList<>();

    /**
     * 10А диапазон балла [70: 100],
     *
     * 10Б диапазон балла [50: 70);
     *
     * 10B диапазон балла (0: 50);
     */
    @Before
    public void beforeTest() {
        students.add(new Student("Alex",70));
        students.add(new Student("Mark",71));
        students.add(new Student("Lera",72));
        students.add(new Student("Natasha",50));
        students.add(new Student("Katerina",51));
        students.add(new Student("Andrew",1));
    }

    @Test
    public void filterClassA() {
        Predicate<Student> predicate = student -> student.getScore() >= 70 && student.getScore() <= 100;
        assertThat (new School().collect(students, predicate).size(), is(3));
    }

    @Test
    public void filterClassB() {
        Predicate<Student> predicate = student -> student.getScore() >= 50 && student.getScore() < 70;
        assertThat (new School().collect(students, predicate).size(), is(2));
    }

    @Test
    public void filterClassC() {
        Predicate<Student> predicate = student -> student.getScore() > 0 && student.getScore() < 50;
        assertThat (new School().collect(students, predicate).size(), is(1));
    }
}
