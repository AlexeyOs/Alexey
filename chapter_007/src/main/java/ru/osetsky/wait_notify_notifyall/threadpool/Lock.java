package ru.osetsky.wait_notify_notifyall.threadpool;

/**
 * Created by koldy on 14.03.2018.
 */
public class Lock{
    private static boolean isLocked = false;
    private static Thread owner;
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();//создал объект
        Thread thread = new Thread(new ObjectLocker(object));//Привязал объект к потоку
        thread.start();//запустил поток
        Lock l = new Lock();
        l.lock();//блокирую поток
        l.unlock();//заново запускаю
    }
    public synchronized void lock() throws InterruptedException{
        while (isLocked){         // проверяем если текущий объект залочен, то
            wait();               // ждем уведомления от другого потока, при реактивации будет снова проверен предикат
        }                         // если isLocked будет true, то снова ожидаем (wait), иначе выходим из цикла while
        isLocked = true;                 // лочим текущий объект.
        owner = Thread.currentThread();  // записываем owner'ом текущий поток.
    }
    public synchronized void unlock(){
        if(Thread.currentThread() == owner){
            isLocked = false;
            owner = null;
            notifyAll();
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
