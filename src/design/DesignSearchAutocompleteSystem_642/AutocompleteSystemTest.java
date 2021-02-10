package design.DesignSearchAutocompleteSystem_642;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutocompleteSystemTest {
    @Test
    public void test() {
        AutocompleteSystem a = new AutocompleteSystem(new String[] {"i love you", "island", "ironman", "i love leetcode"}, new int[] {5, 3, 2, 2});
        assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        assertEquals(Arrays.asList("i love you", "i love leetcode"), a.input(' '));
        assertEquals(new ArrayList<>(), a.input('a'));
        assertEquals(new ArrayList<>(), a.input('#'));

        assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        assertEquals(Arrays.asList("island"), a.input('s'));
        assertEquals(new ArrayList<>(), a.input('#'));

        assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        assertEquals(Arrays.asList("island", "is"), a.input('s'));
        assertEquals(new ArrayList<>(), a.input('#'));

        assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        assertEquals(Arrays.asList("i love you", "i love leetcode", "i a"), a.input(' '));
        assertEquals(Arrays.asList("i a"), a.input('a'));
        assertEquals(new ArrayList<>(), a.input('#'));

        assertEquals(Arrays.asList("i love you", "island", "i a"), a.input('i'));

        a = new AutocompleteSystem(new String[] {"i love you", "island", "ironman", "i love leetcode"}, new int[] {5, 3, 2, 2});
        assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        assertEquals(Arrays.asList("i love you", "i love leetcode"), a.input(' '));
        assertEquals(new ArrayList<>(), a.input('a'));
        assertEquals(new ArrayList<>(), a.input('#'));
        assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        assertEquals(Arrays.asList("i love you", "i love leetcode", "i a"), a.input(' '));
        assertEquals(Arrays.asList("i a"), a.input('a'));
        assertEquals(new ArrayList<>(), a.input('#'));

        a = new AutocompleteSystem(new String[] {"abc", "abbc", "a"}, new int[] {3, 3, 3});
        assertEquals(new ArrayList<>(), a.input('b'));
        assertEquals(new ArrayList<>(), a.input('c'));
        assertEquals(new ArrayList<>(), a.input('#'));
        assertEquals(Arrays.asList("bc"), a.input('b'));
        assertEquals(Arrays.asList("bc"), a.input('c'));
        assertEquals(new ArrayList<>(), a.input('#'));
        assertEquals(Arrays.asList("a", "abbc", "abc"), a.input('a'));
        assertEquals(Arrays.asList("abbc", "abc"), a.input('b'));
        assertEquals(Arrays.asList("abc"), a.input('c'));
        assertEquals(new ArrayList<>(), a.input('#'));
        assertEquals(Arrays.asList("abc", "a", "abbc"), a.input('a'));
        assertEquals(Arrays.asList("abc", "abbc"), a.input('b'));
        assertEquals(Arrays.asList("abc"), a.input('c'));
        assertEquals(new ArrayList<>(), a.input('#'));
    }
}