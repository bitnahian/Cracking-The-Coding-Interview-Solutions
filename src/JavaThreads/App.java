package JavaThreads;

import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        int MAX = 100;

        Thread[] threads = {
                new FizzBuzzThread(true, true, MAX, "FizzBuzz"),
                new FizzBuzzThread(true, false, MAX, "Fizz"),
                new FizzBuzzThread(false, true, MAX, "Buzz"),
                new NumberThread(false, false, MAX)
        };

        for(Thread thread : threads) {
            thread.start();
        }
    }

    public static void mainOld2(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();

                int duration = random.nextInt(4000);

                System.out.println("Starting... ");
                Thread.sleep(duration);
                System.out.println("Finished.");

                return duration;
            }
        });

        service.shutdown();

        try {
            System.out.println("Duration: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void mainOld(String[] args) {
        final Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runner.finished();
    }
}
