package ru.osetsky.waitnotifynotifyall.producerconsumer;

/**
 * Created by koldy on 17.02.2018.
 */
public class Producer implements Runnable {
    private final  SimpleBlockingQueue queue;

    public Producer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Producer " + i);
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
