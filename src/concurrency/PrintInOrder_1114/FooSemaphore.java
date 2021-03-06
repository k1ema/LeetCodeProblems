package concurrency.PrintInOrder_1114;

import java.util.concurrent.Semaphore;

public class FooSemaphore implements Foo {
    // 9 ms, faster than 88.66%; 35.5 MB, less than 100.00%
    private Semaphore s2, s3;

    public FooSemaphore() {
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
