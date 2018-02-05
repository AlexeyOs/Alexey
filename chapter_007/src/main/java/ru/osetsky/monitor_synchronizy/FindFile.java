package ru.osetsky.monitor_synchronizy;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;

/**
 * Created by koldy on 05.02.2018.
 */
public class FindFile implements Runnable {
    private String root;
    private String find;

    private BlockingQueue<String> queue;
    public FindFile(String root, String find, BlockingQueue<String> queue) {
        this.root = root;
        this.find = find;
        this.queue = queue;
    }
    public void findFileRoot(String path) {
        File direct = new File(path);
        if (direct.isDirectory()) {
            File[] files = direct.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (Pattern.matches(this.find, file.getName()) && !file.isDirectory()) {
                        try {
                            this.queue.put(file.getAbsolutePath());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (file.isDirectory()) {
                        findFileRoot(file.getPath());
                    }
                }
            }
        }
    }
    @Override
    public void run() {
        findFileRoot(this.root);
    }
}
