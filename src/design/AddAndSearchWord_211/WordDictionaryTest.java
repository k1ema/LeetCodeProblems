package design.AddAndSearchWord_211;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordDictionaryTest {
    @Test
    public void test() {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        assertFalse(wd.search("pad"));
        assertTrue(wd.search("bad"));
        assertTrue(wd.search(".ad"));
        assertTrue(wd.search("b.."));
        assertTrue(wd.search("..."));
        assertFalse(wd.search("b"));
    }
}
