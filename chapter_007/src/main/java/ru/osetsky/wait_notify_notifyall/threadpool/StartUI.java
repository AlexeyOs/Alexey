package ru.osetsky.wait_notify_notifyall.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.List;

/**
 * Created by koldy on 04.03.2018.
 */
public class StartUI {
    /*
     * Запускаю пул, засикаю время.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPool threadPool = new ThreadPool(8);
        Work work = new Work();
        long start = System.nanoTime();

        List<Double> list = threadPool.add(work);

        double value = 0;
        for (Double aDouble : list) {
            value += aDouble;
        }

        System.out.format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value);

        threadPool.shutDown();
        // реализованный механизм блокировки
        Lock lockObject = new Lock() ;//объект пожет быть в двух состояниях: занят и свободен
        lockObject.run();//запускаю поток
        lockObject.lock();//блокирую поток
        //lockObject.unlock();//разблокирую поток
    }
}
