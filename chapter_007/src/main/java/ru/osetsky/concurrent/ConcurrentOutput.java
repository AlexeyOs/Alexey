package ru.osetsky.concurrent;

public class ConcurrentOutput {
    /**
     * Задание #1016
     * Для понимания того, почему не стоит вызваеть another.run напрямую(метод run не дает указания выполнить свои операторы в отдельной ните)
     */
    public static void main(String[] args) {
        Thread another = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        another.start();
        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        second.start();
        System.out.println(Thread.currentThread().getName());
    }
}