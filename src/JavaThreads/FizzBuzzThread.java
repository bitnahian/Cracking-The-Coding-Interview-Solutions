package JavaThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzzThread extends Thread{

    private static Lock lock = new ReentrantLock();
    protected static int current = 1; // Static variable
    private boolean div3;
    private boolean div5;
    private int max;
    private String toPrint;

    public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint) {
        this.div3 = div3;
        this.div5 = div5;
        this.max = max;
        this.toPrint = toPrint;
    }

    public void print() {
        System.out.println(toPrint);
    }

    public void run() {
        while(true) {
            lock.lock();
            if(current > max)
                return;
            if (((current % 3) == 0) == div3 && ((current % 5) == 0) == div5) {
                print();
                current++;
            }
            lock.unlock();
        }
    }
}

