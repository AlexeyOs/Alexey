package ru.osetsky.wait_notify_notifyall;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by koldy on 17.02.2018.
 */
public class SimpleBlockingQueue {
    private List queue = new LinkedList<>();
    private int limit = 1;
    private int count;
    public SimpleBlockingQueue(int count) {
        this.count = count;
    }
    public synchronized void put(Object object) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(object);
    }
    public synchronized Object take() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }
}
