package ru.osetsky.wait_notify_notifyall.producer_consumer;

/**
 * Created by koldy on 17.02.2018.
 */
public class Consumer implements Runnable{
    private SimpleBlockingQueue queue;

    public Consumer(SimpleBlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
           try {
               System.out.println("Consumer" + queue.take());
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
    }
}
