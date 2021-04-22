package concurrency.PrintFooBarAlternately_1115;

import org.junit.jupiter.api.Test;

class FooBarTest {
    @Test
    void testSemaphore() {
        test(new FooBarSemaphore(3));
    }

    @Test
    void testSynchronized() {
        test(new FooBarSynchronized(5));
    }

    @Test
    void testLock() {
        test(new FooBarLock(4));
    }

    @Test
    void testVolatile() {
        test(new FooBarVolatile(7));
    }

    private void test(FooBar fb) {
        new Thread(() -> {
            try {
                fb.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
