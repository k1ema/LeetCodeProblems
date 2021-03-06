package concurrency.PrintFooBarAlternately_1115;

import java.util.concurrent.Semaphore;

// 16 ms, faster than 83.25%; 37 MB, less than 100.00%
class FooBarSemaphore implements FooBar {
    private int n;
    private Semaphore semFoo, semBar;

    public FooBarSemaphore(int n) {
        this.n = n;
        semFoo = new Semaphore(1);
        semBar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semFoo.release();
        }
    }
}
