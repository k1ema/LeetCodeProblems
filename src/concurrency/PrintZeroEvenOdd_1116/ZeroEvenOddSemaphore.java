package concurrency.PrintZeroEvenOdd_1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

// 4 ms, faster than 100.00%; 35.5 MB, less than 100.00%
public class ZeroEvenOddSemaphore implements ZeroEvenOdd {
    private int n;
    private Semaphore sZero, sEven, sOdd;

    ZeroEvenOddSemaphore(int n) {
        this.n = n;
        sZero = new Semaphore(1);
        sEven = new Semaphore(0);
        sOdd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean even = false;
        for (int i = 0; i < n; i++) {
            sZero.acquire();
            printNumber.accept(0);
            if (even) {
                sEven.release();
            } else {
                sOdd.release();
            }
            even = !even;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            sEven.acquire();
            printNumber.accept(i);
            sZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            sOdd.acquire();
            printNumber.accept(i);
            sZero.release();
        }
    }
}
