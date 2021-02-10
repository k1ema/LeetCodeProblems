package design.InsertDeleteGetRandom_380;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomizedSetTest {
    @Test
    public void test() {
        RandomizedSet r = new RandomizedSet();
        assertFalse(r.remove(0));
        assertFalse(r.remove(0));
        assertTrue(r.insert(10));
        assertEquals(10, r.getRandom());
        assertTrue(r.remove(10));
        assertTrue(r.insert(10));
    }
}
