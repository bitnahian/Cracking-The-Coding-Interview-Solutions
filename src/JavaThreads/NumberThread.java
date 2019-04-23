package JavaThreads;

public class NumberThread extends FizzBuzzThread {
    public NumberThread(boolean div3, boolean div5, int max) {
        super(div3, div5, max, null);
    }

    @Override
    public void print() {
        System.out.println(current);
    }
}

