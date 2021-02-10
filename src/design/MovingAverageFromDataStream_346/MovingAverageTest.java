package design.MovingAverageFromDataStream_346;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovingAverageTest {
    @Test
    public void test() {
        MovingAverage m = new MovingAverage(3);
        assertEquals(1, m.next(1), 1e-5);
        assertEquals(5.5, m.next(10), 1e-5);
        assertEquals(4.66667, m.next(3), 1e-5);
        assertEquals(6, m.next(5), 1e-5);
    }
}
