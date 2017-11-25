package ru.osetsky.jmm;

/**
 * Created by koldy on 25.11.2017.
 */
public class MyRunnable implements Runnable {

        public void run() {
            methodOne();
        }

    public void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 = MySharedObject.SHAREDINSTANCE;

        localVariable1 += localVariable1;

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);

        localVariable1  += localVariable1;
    }
}

