package concurrency.FizzBuzzMultithreaded_1195;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    @DisplayName("Fizzbuzz")
    public void test() throws Exception {
        Queue<String> strings = new LinkedBlockingQueue<>();

        FizzBuzz fizzBuzz = new FizzBuzz(16);

        Thread t1, t2, t3, t4;

        (t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> strings.add("fizz"));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        })).start();

        (t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> strings.add("buzz"));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        })).start();

        (t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> strings.add("fizzbuzz"));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        })).start();

        (t4 = new Thread(() -> {
            try {
                fizzBuzz.number(number -> strings.add("" + number));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
                Thread.currentThread().interrupt();
            }
        })).start();

        t4.join();
        t3.join();
        t2.join();
        t1.join();

        assertEquals(
                Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz", "16"),
                new ArrayList<>(strings)
        );
    }
}
