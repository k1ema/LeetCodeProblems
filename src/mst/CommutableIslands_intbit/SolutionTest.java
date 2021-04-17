package mst.CommutableIslands_intbit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new SolutionPrimLazy()),
                Arguments.of(new SolutionKruskal())
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(Solution s) {
        assertEquals(6, s.solve(4, Arrays.asList(
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 3, 4),
                Arrays.asList(1, 4, 3),
                Arrays.asList(4, 3, 2),
                Arrays.asList(1, 3, 10))));
        assertEquals(6, s.solve(4, Arrays.asList(
                Arrays.asList(1, 2, 1),
                Arrays.asList(2, 3, 2),
                Arrays.asList(3, 4, 4),
                Arrays.asList(1, 4, 3))));
    }
}
