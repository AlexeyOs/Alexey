package ru.osetsky;

/**
 * Created by koldy on 28.10.2017.
 */
public class CountWords implements Runnable {
    /**
     * Input String.
     */
    private final String line;

    /**
     * @param line - input String.
     */
    public CountWords(final String line) {
        this.line = line;
    }

    /**
     * run calculate count words.
     */
     public int words() {
         System.out.println("Second is started.");
         int countSpace = 0;
         int countWord = 0;
         for (int i = 0; i < this.line.length(); i++) {
             char a = this.line.charAt(i);
             if (a == ' ') {
                 countSpace++;
             }
             if (Thread.currentThread().isInterrupted()) {
                 System.out.println("Thread words is interrupted.");
                 break;
             }
         }
         countWord = countSpace + 1;
         return countWord;
     }
    @Override
    public void run() {
        System.out.println("countWord" + ':' + words());
    }
}
