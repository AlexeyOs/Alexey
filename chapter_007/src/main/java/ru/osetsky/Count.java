package ru.osetsky;

/**
 * Created by koldy on 15.10.2017.
 */
public class Count {
    /**
     * Class is calculate count words in input String.
     */
    public static class CountWord implements Runnable {
        /**
         * Input String.
         */
    private final String line;

        /**
         * @param line - input String.
         */
    public CountWord(final String line) {
        this.line = line;
    }

        /**
         * run calculate count words.
         */
        @Override
    public void run() {
        int countSpace = 0;
        int countWord = 0;
        for (int i = 0; i < this.line.length(); i++) {
            char a = this.line.charAt(i);
            if (a == ' ') {
                countSpace++;
            }
        }
        countWord = countSpace + 1;
        System.out.println("countWord" + ':' + countWord);
    }
}

    /**
     * Class is calculate count spaces in input String.
     */
    public static class CountSpace implements Runnable {
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
            int countSpace = 0;
            for (int i = 0; i < this.line.length(); i++) {
                char a = line.charAt(i);
                if (a == ' ') {
                    countSpace++;
                }
            }
            System.out.println("countSpace" + ':' + countSpace);
        }
    }

    /**
     * @param args - default.
     * @throws InterruptedException - Exception.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(new CountSpace("в лесу родилась елочка"));
        Thread second = new Thread(new CountWord("в лесу она росла"));
        double startTime = System.currentTimeMillis();
        first.start();
        System.out.println("First is started.");
        second.start();
        System.out.println("Second is started.");
        while (first.isAlive() && second.isAlive()) {
            System.out.println("waiting...");
            if (System.currentTimeMillis() - startTime > 1) {
                    first.interrupt();
                    second.interrupt();
            }
        }
    }
}
