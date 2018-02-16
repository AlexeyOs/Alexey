package ru.osetsky.wait_notify_notifyall;

/**
 * Created by koldy on 17.02.2018.
 */
public class Customer implements Runnable{
    private SimpleBlockingQueue queue;

    public Customer(SimpleBlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
           try {
               System.out.println("Customer" + queue.take());
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
    }
}
