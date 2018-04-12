package ru.pro.exam;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 30.03.2018.
 */
public class TestWordVerification {

    @Test
    public void whenCheckSameWords() {
        assertThat(true,is(new WordVerification().verification("Telephone","Telephone")));
    }
    @Test
    public void whenCheckDifferentWords() {
        assertThat(false,is(new WordVerification().verification("Car","Cart")));
    }
    @Test
    public void whenCheckDifferentWordsDefferentCharacter() {
        assertThat(false,is(new WordVerification().verification("Cucumber","Sale")));
    }
    @Test
    public void whenCheckDifferentWordsManyRepeat() {
        assertThat(false,is(new WordVerification().verification("Canumber","Cucumber")));
    }
}
