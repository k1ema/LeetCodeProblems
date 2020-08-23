package trie.StreamOfCharacters_1032;

import org.junit.Assert;
import org.junit.Test;

public class StreamCheckerTest {
    @Test
    public void test() {
        StreamChecker s = new StreamChecker(new String[] {"cd", "f", "kl"});
        Assert.assertFalse(s.query('a'));
        Assert.assertFalse(s.query('b'));
        Assert.assertFalse(s.query('c'));
        Assert.assertTrue(s.query('d'));
        Assert.assertFalse(s.query('e'));
        Assert.assertTrue(s.query('f'));
        Assert.assertFalse(s.query('g'));
        Assert.assertFalse(s.query('h'));
        Assert.assertFalse(s.query('i'));
        Assert.assertFalse(s.query('j'));
        Assert.assertFalse(s.query('k'));
        Assert.assertTrue(s.query('l'));
    }
}
