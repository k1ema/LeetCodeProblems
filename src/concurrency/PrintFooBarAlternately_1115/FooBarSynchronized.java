package concurrency.PrintFooBarAlternately_1115;

// 16 ms, faster than 83.25%; 36.6 MB, less than 100.00%
class FooBarSynchronized implements FooBar {
    private int n;
    private int flag = 0;

    FooBarSynchronized(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (this) {
                if (flag != 0) wait();
                printFoo.run();
                flag = 1;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (this) {
                if (flag != 1) wait();
                printBar.run();
                flag = 0;
                notify();
            }
        }
    }
}