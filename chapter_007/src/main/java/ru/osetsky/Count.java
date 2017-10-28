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
        try {
            count.start();
            count.join(WATCH_DOG_TIMER);
            time.start();
            time.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
//        Thread first = new Thread(new CountSpace("в лесу родилась елочка"));
//        Thread second = new Thread(new CountWords("в лесу она росла"));
//        double startTime = System.currentTimeMillis();
//        first.start();
//        second.start();
//        Thread.currentThread().sleep(1000);
//        System.out.println("waiting...");
//        first.interrupt();
//        second.interrupt();
        new Count("job for java").count();
    }
}
