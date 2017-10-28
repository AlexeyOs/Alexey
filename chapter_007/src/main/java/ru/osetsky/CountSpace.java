package ru.osetsky;

/**
 * Created by koldy on 29.10.2017.
 */
/**
 * Class is calculate count spaces in input String.
 */
public class CountSpace implements Runnable {
    /**
     * Input String.
     */
    private final String line;

    /**
     * @param line - input String.
     */
    public CountSpace(final String line) {
        this.line = line;
    }

    /**
     * run calculate count spaces.
     */
    @Override
    public void run() {
        System.out.println("First is started.");
        int countSpace = 0;
        for (int i = 0; i < this.line.length(); i++) {
            char a = line.charAt(i);
            if (a == ' ') {
                countSpace++;
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread words is interrupted.");
                break;
            }
        }
        System.out.println("countSpace" + ':' + countSpace);
    }
}
