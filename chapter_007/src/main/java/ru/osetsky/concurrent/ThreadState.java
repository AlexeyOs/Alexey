package ru.osetsky.concurrent;

public class ThreadState {
    /**
     * Нить main должна дождаться завершения двух созданных нитей и вывести на консоль сообщение, что работа завершена.
     */
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> {}
        );
        System.out.println(first.getName());
        first.start();

        Thread second = new Thread(
                () -> {}
        );
        System.out.println(second.getName());
        second.start();

        while (first.getState() != Thread.State.TERMINATED && second.getState() != Thread.State.TERMINATED) {
            System.out.println("Waiting ...");
        }
        System.out.println("Work completed");
    }
}
