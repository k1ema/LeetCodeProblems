package hashtable.FirstUniqueNumber_1429;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstUniqueTest {
    @Test
    public void test() {
        FirstUnique s = new FirstUnique(new int[] {2, 3, 5});
        assertEquals(2, s.showFirstUnique());
        s.add(5);
        assertEquals(2, s.showFirstUnique());
        s.add(2);
        assertEquals(3, s.showFirstUnique());
        s.add(3);
        assertEquals(-1, s.showFirstUnique());

        s = new FirstUnique(new int[] {7, 7, 7, 7, 7, 7});
        assertEquals(-1, s.showFirstUnique());
        s.add(7);
        s.add(3);
        s.add(3);
        s.add(7);
        s.add(17);
        assertEquals(17, s.showFirstUnique());

        s = new FirstUnique(new int[] {809});
        assertEquals(809, s.showFirstUnique());
        s.add(809);
        assertEquals(-1, s.showFirstUnique());
    }
}