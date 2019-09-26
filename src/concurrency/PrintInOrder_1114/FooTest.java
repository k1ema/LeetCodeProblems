package concurrency.PrintInOrder_1114;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FooTest {
    private Thread t1, t2, t3;

    @BeforeEach
    void setUp() {
        Foo foo = new Foo();
        t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });
        t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });
        t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });
    }

    @Test
    @DisplayName("1-2-3")
    void test1() {
        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    @DisplayName("1-3-2")
    void test2() {
        t1.start();
        t3.start();
        t2.start();
    }

    @Test
    @DisplayName("2-1-3")
    void test3() {
        t2.start();
        t1.start();
        t3.start();
    }

    @Test
    @DisplayName("2-3-1")
    void test4() {
        t2.start();
        t3.start();
        t1.start();
    }

    @Test
    @DisplayName("3-1-2")
    void test5() {
        t3.start();
        t1.start();
        t2.start();
    }

    @Test
    @DisplayName("3-2-1")
    void test6() {
        t3.start();
        t2.start();
        t1.start();
    }
}
