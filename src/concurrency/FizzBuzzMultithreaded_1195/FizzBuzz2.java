package concurrency.FizzBuzzMultithreaded_1195;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz2 {
    private int n;
    private AtomicInteger cur = new AtomicInteger(1);

    public FizzBuzz2(int n) {
        this.n = n;
    }

    private void update(int count) {
        if (!cur.compareAndSet(count, count + 1)) {
            throw new ConcurrentModificationException();
        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int count;
        while ((count = cur.get()) <= n) {
            if (count % 3 == 0 && count % 5 != 0) {
                printFizz.run();
                update(count);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int count;
        while ((count = cur.get()) <= n) {
            if (count % 5 == 0 && count % 3 != 0) {
                printBuzz.run();
                update(count);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int count;
        while ((count = cur.get()) <= n) {
            if (count % 15 == 0) {
                printFizzBuzz.run();
                update(count);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        int count;
        while ((count = cur.get()) <= n) {
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                update(count);
            }
        }
    }
}
