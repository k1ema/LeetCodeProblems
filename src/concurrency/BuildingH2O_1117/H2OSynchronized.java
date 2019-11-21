package concurrency.BuildingH2O_1117;

// 12 ms, faster than 59.09%; 37 MB, less than 100.00%
public class H2OSynchronized implements H2O {
    private int flag = 0;

    H2OSynchronized() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while (flag == 2) wait();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            flag++;
            notify();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while (flag != 2) wait();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            flag = 0;
            notify();
        }
    }
}
