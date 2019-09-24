package string.FizzBuzz_412;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","8",
                "Fizz","Buzz","11","Fizz","13","14","FizzBuzz"), s.fizzBuzz(15));
    }
}
