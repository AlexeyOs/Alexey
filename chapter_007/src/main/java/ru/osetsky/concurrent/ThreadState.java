package ru.osetsky.concurrent;

public class ThreadState {
    /**
     * Нить main должна дождаться завершения двух созданных нитей и вывести на консоль сообщение, что работа завершена.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        first.start();

        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        second.start();

        while (first.getState() != Thread.State.TERMINATED && second.getState() != Thread.State.TERMINATED) {
            Thread.sleep(1000);
        }
        System.out.println("Work completed");
    }
}
