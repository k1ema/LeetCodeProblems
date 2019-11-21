package concurrency.BuildingH2O_1117;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class H2OTest {
    @Test
    @DisplayName("Semaphore CDL")
    void testSemaphoreCDL() {
//        test1(new H2OSemaphorCDL());
        test2(new H2OSemaphorCDL());
    }

    @Test
    @DisplayName("Semaphore")
    void testSemaphore() {
        test1(new H2OSemaphor());
        test2(new H2OSemaphor());
    }

    @Test
    @DisplayName("Synchronized")
    void testSynchronized() {
//        test1(new H2OSynchronized());
        test2(new H2OSynchronized());
    }

    private void test1(H2O h2o) {
        new Thread(() -> {
            try {
                h2o.hydrogen(() -> System.out.print("H"));
                h2o.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(() -> {
            try {
                h2o.oxygen(() -> System.out.print("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    private void test2(H2O h2o) {
        new Thread(() -> {
            try {
                h2o.hydrogen(() -> System.out.print("H"));
                h2o.hydrogen(() -> System.out.print("H"));
                h2o.hydrogen(() -> System.out.print("H"));
                h2o.hydrogen(() -> System.out.print("H"));
                h2o.hydrogen(() -> System.out.print("H"));
                h2o.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(() -> {
            try {
                h2o.oxygen(() -> System.out.print("O"));
                h2o.oxygen(() -> System.out.print("O"));
                h2o.oxygen(() -> System.out.print("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
