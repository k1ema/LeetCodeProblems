package trie.WordSquares_425;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(Arrays.asList(
                Arrays.asList("ball", "area", "lead", "lady"),
                Arrays.asList("wall", "area", "lead", "lady")
        ), s.wordSquares(new String[] {"area", "lead", "wall", "lady", "ball"}));

        assertEquals(Arrays.asList(
                Arrays.asList("baba", "abat", "baba", "atal"),
                Arrays.asList("baba", "abat", "baba", "atan")
        ), s.wordSquares(new String[] {"abat", "baba", "atan", "atal"}));

        assertEquals(Collections.singletonList(
                Arrays.asList("aaaa", "aaaa", "aaaa", "aaaa")
        ), s.wordSquares(new String[] {"aaaa"}));
    }
}