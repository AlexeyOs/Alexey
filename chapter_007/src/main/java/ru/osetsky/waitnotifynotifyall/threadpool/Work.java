package ru.osetsky.waitnotifynotifyall.threadpool;

/**
 * Created by koldy on 04.03.2018.
 */
public class Work {
    /*
     * Нагружаю процессор.
     */
    public Double count(double count) {
        for (int i = 0; i < 100; i++) {
            count = count + Math.tan(count);
        }
        return count;
    }
}
