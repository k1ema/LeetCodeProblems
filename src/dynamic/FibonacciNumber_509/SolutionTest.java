package dynamic.FibonacciNumber_509;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.fib(2));
        assertEquals(2, s.fib(3));
        assertEquals(3, s.fib(4));
        assertEquals(5, s.fib(5));
        assertEquals(8, s.fib(6));
        assertEquals(13, s.fib(7));
    }
}
