package binarySearch.SnapshotArray_1146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapshotArrayTest {
    @Test
    public void test() {
        SnapshotArrayBS s = new  SnapshotArrayBS(3);
        s.set(0, 5);
        assertEquals(0, s.snap());
        s.set(0, 6);
        assertEquals(5, s.get(0, 0));
        assertEquals(6, s.get(0, 1));

        s = new  SnapshotArrayBS(1);
        s.set(0, 15);
        s.snap();
        s.snap();
        s.snap();
        assertEquals(15, s.get(0, 2));
        s.snap();
        s.snap();
        assertEquals(15, s.get(0, 0));

        s = new  SnapshotArrayBS(4);
        s.snap();
        s.snap();
        assertEquals(0, s.get(3, 1));
        s.set(2, 4);
        s.snap();
        s.set(1, 4);
        assertEquals(4, s.get(2, 2));
        assertEquals(4, s.get(2, 3));
        assertEquals(4, s.get(1, 3));
    }
}
