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
            synchronized (this) {
                while (flag == 1) wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag == 0) wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 0;
                this.notifyAll();
            }
        }
    }
}