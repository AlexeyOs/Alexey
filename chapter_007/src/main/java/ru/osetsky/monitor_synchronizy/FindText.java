package ru.osetsky.monitor_synchronizy;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by koldy on 05.02.2018.
 */
public class FindText implements Runnable {
    private BlockingQueue<String> queue;
    private List<String> result = new ArrayList<>();
    private String text;

    public FindText(String text, BlockingQueue<String> queue, List<String> result) {
        this.text = text;
        this.queue = queue;
        this.result = result;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            String line = this.queue.poll();
            if (line == null && !ParallerSearch.isAlive()) {
                return;
            }
            if (line != null) {
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(new FileInputStream(line), "utf-8"));
                    String result;
                    while ((result = reader.readLine()) != null) {
                        if (result.toLowerCase().contains(this.text.toLowerCase())) {
                            this.result.add(result);
                            break;
                        }
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
