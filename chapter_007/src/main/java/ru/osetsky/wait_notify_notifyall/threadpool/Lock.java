package ru.osetsky.wait_notify_notifyall.threadpool;

/**
 * Created by koldy on 14.03.2018.
 */
public class Lock implements Runnable {

    private boolean freeOrBusy = false;
    private int id_run_object;
    @Override
    public void run() {
        while (!freeOrBusy){
            //Runnable runnable = null;
        }
    }
    public void lock(){
        freeOrBusy = true;//блокирую поток
        id_run_object = hashCode();//запоминаю хашкоды, чтобы затем разблокировать в unlock
    }
    public void unlock() {
        if (hashCode() == id_run_object) {
            freeOrBusy = false;
        }
    }
}
