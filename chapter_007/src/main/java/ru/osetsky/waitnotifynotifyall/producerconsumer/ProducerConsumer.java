package ru.osetsky.waitnotifynotifyall.producerconsumer;

/**
 * Created by koldy on 16.02.2018.
 */
public class ProducerConsumer {
    private static SimpleBlockingQueue queue = new SimpleBlockingQueue(10);;
//    private final Object lock = new Object();
//    private boolean blockCustomer = true; //thread stack
//
//    public void doSomething() throws InterruptedException {
//        synchronized (lock){
//            while (this.blockCustomer) {
//                System.out.println(String.format("%s wait", Thread.currentThread().getId()));
//                lock.wait();
//            }
//            System.out.println(String.format("%s usefull work", Thread.currentThread().getId()));
//        }
//    }
//    public void changeBlock(boolean enable) {
//        synchronized (this.lock){
//            System.out.println(String.format("%s enable", Thread.currentThread().getId()));
//            this.blockCustomer = enable;
//            this.lock.notify();
//        }
//    }

    public static void main(String[] args) {
//        final ProducerConsumer blockingWork = new ProducerConsumer();
//        //customer
//        Thread customer = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    blockingWork.doSomething();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        //producer
//        Thread producer = new Thread() {
//            @Override
//            public void run() {
//                blockingWork.changeBlock(false);
//            }
//        };
        Thread producer = new Thread(new Producer((queue)));
        Thread customer = new Thread(new Consumer((queue)));
        producer.start();
        customer.start();
    }
}
