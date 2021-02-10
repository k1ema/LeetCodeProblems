package bitManipulation.SumOfTwoIntegers_371;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.getSum(2, 1));
        assertEquals(4, s.getSum(3, 1));
        assertEquals(1, s.getSum(-2, 3));
//        System.out.println(Integer.toBinaryString(-100));
//        System.out.println(Integer.toBinaryString(-90));
        assertEquals(Integer.toBinaryString(-190), Integer.toBinaryString(s.getSum(-100, -90)));
        assertEquals(Integer.toBinaryString(-3), Integer.toBinaryString(s.getSum(-1, -2)));
    }
}
