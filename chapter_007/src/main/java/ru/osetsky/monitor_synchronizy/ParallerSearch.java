package ru.osetsky.monitor_synchronizy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

    List<String> paths = new LinkedList<String>();

    List<String> pathResult = new LinkedList<String>();

    ParallerSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    /*
     Вспомогательный метод поиска.
     */
    public void searchInDirectory(File[] files) {
        for(File file:files){
            if (file.isDirectory()) {
                search(file);
                continue;
            }
            if (this.exts.contains(getFileExtension(file.getName()))) {
                this.paths.add(file.getPath());
            }
        }
    }

    /*
     Получение расширения файла.
     */
    public String getFileExtension(String str){
        int index = str.indexOf('.');
        return index == -1 ? null : str.substring(index);
    }
    /*
     Поиск поддиректории.
     */
    public List<String> search(File file){
        File[] files = file.listFiles();
        searchInDirectory(files);
        if (this.paths.size()>0){
            this.threadSearchString();
        }
        return this.pathResult;
    }

    /*
     Инициализирует два дополнительных потока, суть которых заключается в том, что бы брать половину списка и искать
     совпадения.
     */
    public void threadSearchString() {
        int threadCount = this.paths.size() / 2;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < paths.size() / 2;i++) {
                    if (fileContainsString(paths.get(i))){
                        pathResult.add(paths.get(i));
                    }
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = paths.size() / 2; i < paths.size();i++) {
                    if (fileContainsString(paths.get(i))){
                        pathResult.add(paths.get(i));
                    }
                }
            }
        });

        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    /*
       Метод для поиска строки.
     */
    public boolean fileContainsString(String path) {
        File file = new File(path);
        boolean result = false;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            try {
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    if (line.split(this.text).length > 1 || this.text.equals(line)){
                        result = true;
                        break;
                    }
                }
            } finally {
                scanner.close();
            }
        }
        return result;
    }
    /**
      Метод для запуска поиска.
     */
    public List<String> search() {
        File[] folderEntries = new File(this.root).listFiles();
        searchInDirectory(folderEntries);
        if (this.paths.size() > 0) {
            this.threadSearchString();
        }
        return this.pathResult;
    }
    public static void main(String[] args) {
        LinkedList<String> exts = new LinkedList<String>();
        exts.add(".txt");
        ParallerSearch parallerSearch = new ParallerSearch("C:\\projects\\Alexey\\chapter_007\\src\\tmp", "test", exts);
        for (String s : parallerSearch.search()) {
            System.out.println(s);
        }
    }

}
