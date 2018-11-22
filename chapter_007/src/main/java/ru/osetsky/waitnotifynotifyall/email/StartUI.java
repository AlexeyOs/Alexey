package ru.osetsky.waitnotifynotifyall.email;


import java.util.concurrent.ExecutionException;

/**
 * Created by koldy on 28.10.2018.
 */
public class StartUI {
    /*
     * Запускаю пул, засикаю время.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EmailNotification emailNotification = new EmailNotification("koldyn20104@mail.ru", "vfnhtirf12");
        emailNotification.emailTo(new User("alex","koldyn20104@mail.ru"));
    }

}
