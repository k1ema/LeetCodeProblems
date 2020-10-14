package hashtable.SnapshotArray_1146;

import org.junit.Assert;
import org.junit.Test;

public class ShapshotArrayTest {
    @Test
    public void test() {
        SnapshotArrayBS s = new  SnapshotArrayBS(3);
        s.set(0, 5);
        Assert.assertEquals(0, s.snap());
        s.set(0, 6);
        Assert.assertEquals(5, s.get(0, 0));
        Assert.assertEquals(6, s.get(0, 1));

        s = new  SnapshotArrayBS(1);
        s.set(0, 15);
        s.snap();
        s.snap();
        s.snap();
        Assert.assertEquals(15, s.get(0, 2));
        s.snap();
        s.snap();
        Assert.assertEquals(15, s.get(0, 0));

        s = new  SnapshotArrayBS(4);
        s.snap();
        s.snap();
        Assert.assertEquals(0, s.get(3, 1));
        s.set(2, 4);
        s.snap();
        s.set(1, 4);
        Assert.assertEquals(4, s.get(2, 2));
        Assert.assertEquals(4, s.get(2, 3));
        Assert.assertEquals(4, s.get(1, 3));
    }
}
