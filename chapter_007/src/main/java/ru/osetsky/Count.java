package ru.osetsky;

/**
 * Created by koldy on 15.10.2017.
 */
public class Count {
    /**
     * Wait before terminate.
     */
    private static final long WATCH_DOG_TIMER = 1000;

    /**
     * Count.
     */
    private final Thread count;
    /**
     * Time.
     */
    private final Thread time;

    /**
     * Constructor initialize two threads.
     *
     * @param line - words.
     */
    public Count(String line) {
        this.count = new Thread(new Count.CountChar(line));
        this.time = new Thread(new Count.Time());
    }


    /**
     * Start threads.
     */
    public void count() {
        System.out.println("Start");
        count.start();
        time.start();
        System.out.println("End");
    }


    /**
     * Class interrupter.
     */
    public class Time implements Runnable {
        /**
         * Run.
         */
        @Override
        public void run() {
            if (count != null && count.isAlive()) {
                System.out.printf("%s %s %n", "Terminate: ", count.getName());
                count.interrupt();
            }
        }
    }


    /**
     * Class counter.
     */
    public class CountChar implements Runnable {

        /**
         * Counter.
         */
        private final CountWords counter;

        /**
         * Constructor initialize counter.
         *
         * @param line - words.
         */
        public CountChar(String line) {
            this.counter = new CountWords(line);
        }

        /**
         * Run.
         */
        @Override
        public void run() {

            int words = this.counter.words();
            if (!count.isInterrupted()) {
                System.out.printf("%s %d %n", "Words", words);
            }
        }
    }
    /**
     * @param args - default.
     * @throws InterruptedException - Exception.
     */
    public static void main(String[] args) throws InterruptedException {
        new Count("job for java").count();
    }
}
