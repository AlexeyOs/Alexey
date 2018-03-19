package ru.osetsky.wait_notify_notifyall.threadpool;

/**
 * Created by koldy on 14.03.2018.
 */
public class Lock{

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();//создал объект
        Thread thread = new Thread(new ObjectLocker(object));//Привязал объект к потоку
        thread.start();//запустил поток
        lock();//блокирую поток
        unlock();//заново запускаю
    }

    private static void lock() throws InterruptedException {
        if (!isLocked) {
                isLocked = true;
                owner = Thread.currentThread();//запихиваю в owner текущий поток
        } else {
            Thread.currentThread().wait();
        }
    }
    private static boolean isLocked = false;
    private static Thread owner;
    private static void unlock() {
        if (Thread.currentThread() == owner) {
            synchronized (owner) {
                isLocked = false;
                owner.notify();//разбуть поток захваченный owner
            }
        }
    }

    public static class ObjectLocker implements Runnable {
        private Object object;
        public ObjectLocker(Object object){
            this.object = object;
        }
        @Override
        public void run() {
            System.out.println("Start thread");//поток стартовал
        }

    }
}
