package concurrency.PrintFooBarAlternately_1115;

// 15 ms, faster than 100.00%; 36.3 MB, less than 100.00%
public class FooBarVolatile implements FooBar {
    private int n;
    private volatile int flag = 0;

    FooBarVolatile(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (flag == 1) wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (flag == 0) wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 0;
                notify();
            }
        }
    }
}
