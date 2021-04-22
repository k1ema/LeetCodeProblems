package concurrency.PrintInOrder_1114;

public class FooVolatile implements Foo {
    private volatile boolean first, second;

    public FooVolatile() {
        first = false;
        second = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        first = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!first) {
        }
        printSecond.run();
        second = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!second) {
        }
        printThird.run();
    }
}
