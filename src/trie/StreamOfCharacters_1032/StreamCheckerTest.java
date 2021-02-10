package trie.StreamOfCharacters_1032;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamCheckerTest {
    @Test
    public void test() {
        StreamChecker s = new StreamChecker(new String[] {"cd", "f", "kl"});
        assertFalse(s.query('a'));
        assertFalse(s.query('b'));
        assertFalse(s.query('c'));
        assertTrue(s.query('d'));
        assertFalse(s.query('e'));
        assertTrue(s.query('f'));
        assertFalse(s.query('g'));
        assertFalse(s.query('h'));
        assertFalse(s.query('i'));
        assertFalse(s.query('j'));
        assertFalse(s.query('k'));
        assertTrue(s.query('l'));
    }
}
