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
     */
    public static void main(String[] args) {
        System.out.println("start");
        new Thread(new CountSpace("в лесу родилась елочка")).start();
        new Thread(new CountWord("в лесу она росла")).start();
        System.out.println("finish");
    }
}
