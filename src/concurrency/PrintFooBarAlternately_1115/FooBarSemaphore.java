package concurrency.PrintFooBarAlternately_1115;

import java.util.concurrent.Semaphore;

// 16 ms, faster than 83.25%; 37 MB, less than 100.00%
class FooBarSemaphore implements FooBar {
    private int n;
    private Semaphore semaphore1, semaphore2;

    FooBarSemaphore(int n) {
        this.n = n;
        semaphore1 = new Semaphore(0);
        semaphore2 = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore2.release();
        }
    }
}
