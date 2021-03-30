package heap.FindMedianFromDataStream_295;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianFinderTest {
    @Test
    public void test() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        assertEquals(1.5, mf.findMedian(), 1e-5);
        mf.addNum(3);
        assertEquals(2, mf.findMedian(), 1e-5);
    }
}
