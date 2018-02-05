package ru.osetsky.monitor_synchronizy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by koldy on 22.01.2018.
 */
public class ParallerSearch {
    /*
     Хранения стартовой директории.
     */
    String root;
    /*
     Хранения путей файлов.
     */
    String text;
    /*
     Хранения путей файлов с расширением exts.
     */
    List<String> exts = new ArrayList();

    /*
      Все потоки
     */
    private List<Thread> threadAll = new ArrayList<>();
    private List<String> result = new ArrayList<>();
    /*
       Очередь
     */
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private static List<Thread> thread = new ArrayList<>();

    ParallerSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public static boolean isAlive(){
        boolean isNeedSave = false;
        for (Thread thr : thread){
            if (thr.isAlive()) {
                isNeedSave = true;
            }
        }
        return isNeedSave;
    }

    public void findThreadFile() {
        for (String element : exts) {
            Thread file = new Thread(new FindFile(this.root, element, this.queue));
            thread.add(file);
            file.start();
        }
        this.threadAll.addAll(thread);
    }

    public void findThreadText() {
        Thread thread = new Thread(new FindText(this.text, this.queue, this.result));
        this.threadAll.add(thread);
        thread.start();
    }

    public void start() {
        System.out.println("start search...");
        findThreadFile();
        findThreadText();

        for (Thread thread : threadAll) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (String s : this.result) {
            System.out.println(s);
        }
        System.out.println("Fount " + this.result.size() + " files.");
    }

public static void main(String[] args) {
    String root = "d:/";
    String text = "java";
    List<String> list = new ArrayList<>();
    list.add(".*.txt");
    list.add(".*.xml");
    ParallerSearch search = new ParallerSearch(root, text, list);
    search.start();
}
}
