package concurrency.PrintInOrder_1114;

public class FooSynchronized implements Foo {
    // 8 ms, faster than 97.06%, 35.8 MB, less than 100.00%
    private boolean first, second;

    public FooSynchronized() {
        first = false;
        second = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        first = true;
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!first) wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!second) wait();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        notifyAll();
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
