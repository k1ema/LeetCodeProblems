package concurrency.PrintZeroEvenOdd_1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

//TODO: wrong implementation!
class ZeroEvenOddLock implements ZeroEvenOdd {
    private int n;
    private Lock lock;
    private Condition printZero, printEven, printOdd;

    ZeroEvenOddLock(int n) {
        this.n = n;
        lock = new ReentrantLock();
        printZero = lock.newCondition();
        printEven = lock.newCondition();
        printOdd = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            boolean even = false;
            for (int i = 0; i < n; i++) {
                if (i != 0) printZero.await();
                printNumber.accept(0);
                if (even) {
                    printEven.signal();
                } else {
                    printOdd.signal();
                }
                even = !even;
            }
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 2; i <= n; i += 2) {
                printEven.await();
                printNumber.accept(i);
                printZero.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i += 2) {
                printOdd.await();
                printNumber.accept(i);
                printZero.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
