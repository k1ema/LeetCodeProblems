package design.ImplementMaxPQ;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxPQTest {
    @Test
    public void testMaxPQ() {
        int n = 10;
        MaxPQ maxPQ = new MaxPQ(n);
        maxPQ.insert(1);
        maxPQ.insert(3);
        maxPQ.insert(10);
        maxPQ.insert(101);
        maxPQ.insert(53);
        maxPQ.insert(9);
        maxPQ.insert(4);
        maxPQ.insert(13);
        maxPQ.insert(21);
        maxPQ.insert(99);

        List<Comparable> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(maxPQ.delMax());
            assertEquals(n - i - 1, maxPQ.size());
        }
        assertTrue(maxPQ.isEmpty());
        assertEquals(Arrays.asList(101, 99, 53, 21, 13, 10, 9, 4, 3, 1), list);
    }
}
