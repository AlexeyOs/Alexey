package ru.osetsky.non_blocking_algoritm;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by koldy on 17.03.2018.
 */
public class NonBlockTest {
    private NonBlock cacheUs = new NonBlock();

    @Test
    public void whenAddElementInMap() {
        cacheUs.add(new User(3, "Alex"));
        cacheUs.add(new User(5, "Igor"));
        cacheUs.add(new User(7, "Vlad"));
        assertThat(cacheUs.size(), is(3));
    }

    @Test
    public void whenAddElementInMapRepeatIndex() {
        cacheUs.add(new User(1, "Alex"));
        cacheUs.add(new User(2, "Igor"));
        cacheUs.add(new User(1, "Vlad"));
        assertThat(cacheUs.size(), is(2));
    }

    @Test
    public void whenUpdateElementInMap() {
        cacheUs.add(new User(1, "Alex"));
        cacheUs.update(1,new User(1,"Igor"));
        assertThat(cacheUs.size(), is(1));
    }


    @Test
    public void whenDeleteElementInMap() {
        cacheUs.add(new User(3, "Alex"));
        cacheUs.add(new User(5, "Igor"));
        cacheUs.delete(3);
        assertThat(cacheUs.size(),is(1));
    }
}
