package concurrency.BuildingH2O_1117;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

// TODO does not work!
public class H2OSemaphorCDL implements H2O {
    private final Semaphore sem = new Semaphore(2);
    private final CountDownLatch cdl = new CountDownLatch(2);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        sem.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        cdl.countDown();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        cdl.await();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        sem.release(2);
    }
}
