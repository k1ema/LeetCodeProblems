package concurrency.PrintInOrder_1114;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FooTest {
    private static class Helper {
        private final Thread t1, t2, t3;

        public Helper(Foo foo) {
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
                    foo.third(() -> System.out.println("third"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            });
        }
    }

    private static Stream<Helper> fooProvider() {
        return Stream.of(
                new Helper(new FooSynchronized()),
                new Helper(new FooSemaphore()),
                new Helper(new FooCountDownLatch()),
                new Helper(new FooVolatile())
        );
    }
    
    @DisplayName("1-2-3")
    @ParameterizedTest(name = "{0}")
    @MethodSource("fooProvider")
    void test1(Helper helper) {
        helper.t1.start();
        helper.t2.start();
        helper.t3.start();
    }

    @DisplayName("1-3-2")
    @ParameterizedTest(name = "{0}")
    @MethodSource("fooProvider")
    void test2(Helper helper) {
        helper.t1.start();
        helper.t3.start();
        helper.t2.start();
    }

    @DisplayName("2-1-3")
    @ParameterizedTest(name = "{0}")
    @MethodSource("fooProvider")
    void test3(Helper helper) {
        helper.t2.start();
        helper.t1.start();
        helper.t3.start();
    }

    @DisplayName("2-3-1")
    @ParameterizedTest(name = "{0}")
    @MethodSource("fooProvider")
    void test4(Helper helper) {
        helper.t2.start();
        helper.t3.start();
        helper.t1.start();
    }

    @DisplayName("3-1-2")
    @ParameterizedTest(name = "{0}")
    @MethodSource("fooProvider")
    void test5(Helper helper) {
        helper.t3.start();
        helper.t1.start();
        helper.t2.start();
    }

    @DisplayName("3-2-1")
    @ParameterizedTest(name = "{0}")
    @MethodSource("fooProvider")
    void test6(Helper helper) {
        helper.t3.start();
        helper.t2.start();
        helper.t1.start();
    }
}
