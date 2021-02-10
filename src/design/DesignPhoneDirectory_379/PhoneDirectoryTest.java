package design.DesignPhoneDirectory_379;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneDirectoryTest {
    @Test
    public void test() {
        PhoneDirectory pd = new PhoneDirectory(3);
        assertEquals(0, pd.get());
        assertTrue(pd.check(1));
        assertEquals(1, pd.get());
        assertFalse(pd.check(1));
        assertEquals(2, pd.get());
        assertEquals(-1, pd.get());
        pd.release(1);
        assertTrue(pd.check(1));
        assertEquals(1, pd.get());
        assertFalse(pd.check(1));

        pd = new PhoneDirectory(3);
        assertEquals(0, pd.get());
        assertEquals(1, pd.get());
        assertTrue(pd.check(2));
        assertEquals(2, pd.get());
        assertFalse(pd.check(2));
        pd.release(2);
        assertTrue(pd.check(2));
    }
}
