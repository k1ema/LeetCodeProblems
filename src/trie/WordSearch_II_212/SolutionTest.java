package trie.WordSearch_II_212;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    private char[][] board = new char[][] {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};

    @Test
    public void test() {
        SolutionHashMap s = new SolutionHashMap();
        assertEquals(Arrays.asList("oath", "eat"),
                s.findWords(board, new String[] {"oath", "pea", "eat", "rain"}));

        assertEquals(Arrays.asList("a"), s.findWords(new char[][] {{'a', 'a'}}, new String[] {"a"}));

        assertEquals(new ArrayList<>(), s.findWords(new char[][] {{'a', 'a'}}, new String[] {"aaa"}));
    }

    @Test
    public void test_II() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("oath", "eat"),
                s.findWords(board, new String[] {"oath", "pea", "eat", "rain"}));

        assertEquals(Arrays.asList("a"), s.findWords(new char[][] {{'a', 'a'}}, new String[] {"a"}));

        assertEquals(new ArrayList<>(), s.findWords(new char[][] {{'a', 'a'}}, new String[] {"aaa"}));
    }
}
