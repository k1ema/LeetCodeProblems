package concurrency.PrintZeroEvenOdd_1116;

import org.junit.jupiter.api.Test;

public class ZeroEvenOddTest {
    @Test
    public void testLock() {
        test(new ZeroEvenOddLock(8));
    }

    @Test
    public void testSemaphore() {
        test(new ZeroEvenOddSemaphore(10));
    }

    private void test(ZeroEvenOdd zeo) {
        new Thread(() -> {
            try {
                zeo.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(() -> {
            try {
                zeo.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(() -> {
            try {
                zeo.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
