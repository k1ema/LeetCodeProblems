package design.ImplementTrie_208;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    @Test
    public void testTrieHashMap() {
        TrieHashMap trie = new TrieHashMap();
        assertFalse(trie.search("apple"));
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }

    @Test
    public void testTrie() {
        Trie trie = new Trie();
        assertFalse(trie.search("apple"));
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }
}
