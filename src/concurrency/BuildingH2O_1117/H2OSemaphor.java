package concurrency.BuildingH2O_1117;

import java.util.concurrent.Semaphore;

// 12 ms, faster than 59.09%; 37.2 MB, less than 100.00%
public class H2OSemaphor implements H2O {
    private Semaphore sem1 = new Semaphore(2);
    private Semaphore sem2 = new Semaphore(0);

    H2OSemaphor() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        sem1.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        sem2.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        sem2.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        sem1.release(2);
    }
}
