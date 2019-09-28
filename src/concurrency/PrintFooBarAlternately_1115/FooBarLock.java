package concurrency.PrintFooBarAlternately_1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 15 ms, faster than 100.00%; 36.5 MB, less than 100.00%
public class FooBarLock implements FooBar {
    private int n;
    private int flag = 0;
    private Lock lock;
    private Condition c1, c2;

    FooBarLock(int n) {
        this.n = n;
        lock = new ReentrantLock();
        c1 = lock.newCondition();
        c2 = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                if (flag == 1) c2.await();
                flag = 1;
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                if (flag == 0) c1.await();
                flag = 0;
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
