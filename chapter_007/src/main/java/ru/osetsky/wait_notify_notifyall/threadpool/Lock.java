package ru.osetsky.wait_notify_notifyall.threadpool;

/**
 * Created by koldy on 14.03.2018.
 */
public class Lock{
    public static void main(String[] args) {
        Object object = new Object();//создал объект
        Thread thread = new Thread(new ObjectLocker(object));//Привязал объект к потоку
        thread.start();//запустил поток
        lock(object);//блокирую поток
        unlock(thread);//заново запускаю
    }

    private static void lock(Object object) {
        synchronized (object) {
            object.notify();//блокирую поток
        }
    }

    private static void unlock(Thread thread) {
        synchronized (thread) {
            thread.start();//запускаю заново
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
