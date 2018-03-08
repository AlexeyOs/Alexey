package ru.osetsky.wait_notify_notifyall.threadpool;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by koldy on 04.03.2018.
 */
public class ThreadPool implements Executor {
    /*
     * Поле очереди.
     */
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    /*
     * Поле для остановки пула.
     */
    private boolean stop = false;

    private ArrayList<Double> list = new ArrayList<>();
    private void init() {
        new Thread(new TaskWorker()).start();
    }
    public ThreadPool(int nThread) {
        for (int i = 0; i < nThread; i++) {
            init();
        }
    }
    /*
     * Перезагрузка пула.
     */
    public void shutDown() {
        stop = true;
    }
    /*
     * Заносит результаты вычисления тангенса в массив.
     */
    public ArrayList<Double> add(Work work) {
        for (int i = 0; i < 15000; i++) {
            this.list.add(work.count(i));
        }
        return this.list;
    }

    @Override
    public void execute(Runnable command) {
        if (!stop) {
            queue.offer(command);
        }
    }

    private class TaskWorker implements Runnable {
        @Override
        public void run() {
            while (!stop) {
                Runnable nextTask = queue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}
