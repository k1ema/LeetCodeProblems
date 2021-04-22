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
            while (true) {
                if (flag == 0) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = 1;
                    break;
                }
                Thread.sleep(1);
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (true) {
                if (flag == 1) {
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag = 0;
                    break;
                }
                Thread.sleep(1);
            }
        }
    }
}
