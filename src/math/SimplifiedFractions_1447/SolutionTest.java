package math.SimplifiedFractions_1447;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("1/2"), s.simplifiedFractions(2));
        assertEquals(Arrays.asList("1/2", "1/3", "2/3"), s.simplifiedFractions(3));
        assertEquals(Arrays.asList("1/2", "1/3", "2/3", "1/4", "3/4"), s.simplifiedFractions(4));
        assertEquals(new ArrayList<>(), s.simplifiedFractions(1));
    }
}