package design.DesignSearchAutocompleteSystem_642;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AutocompleteSystemTest {
    @Test
    public void test() {
        AutocompleteSystem a = new AutocompleteSystem(new String[] {"i love you", "island", "ironman", "i love leetcode"}, new int[] {5, 3, 2, 2});
        Assert.assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        Assert.assertEquals(Arrays.asList("i love you", "i love leetcode"), a.input(' '));
        Assert.assertEquals(new ArrayList<>(), a.input('a'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));

        Assert.assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        Assert.assertEquals(Arrays.asList("island"), a.input('s'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));

        Assert.assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        Assert.assertEquals(Arrays.asList("island", "is"), a.input('s'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));

        Assert.assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        Assert.assertEquals(Arrays.asList("i love you", "i love leetcode", "i a"), a.input(' '));
        Assert.assertEquals(Arrays.asList("i a"), a.input('a'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));

        Assert.assertEquals(Arrays.asList("i love you", "island", "i a"), a.input('i'));

        a = new AutocompleteSystem(new String[] {"i love you", "island", "ironman", "i love leetcode"}, new int[] {5, 3, 2, 2});
        Assert.assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        Assert.assertEquals(Arrays.asList("i love you", "i love leetcode"), a.input(' '));
        Assert.assertEquals(new ArrayList<>(), a.input('a'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));
        Assert.assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), a.input('i'));
        Assert.assertEquals(Arrays.asList("i love you", "i love leetcode", "i a"), a.input(' '));
        Assert.assertEquals(Arrays.asList("i a"), a.input('a'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));

        a = new AutocompleteSystem(new String[] {"abc", "abbc", "a"}, new int[] {3, 3, 3});
        Assert.assertEquals(new ArrayList<>(), a.input('b'));
        Assert.assertEquals(new ArrayList<>(), a.input('c'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));
        Assert.assertEquals(Arrays.asList("bc"), a.input('b'));
        Assert.assertEquals(Arrays.asList("bc"), a.input('c'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));
        Assert.assertEquals(Arrays.asList("a", "abbc", "abc"), a.input('a'));
        Assert.assertEquals(Arrays.asList("abbc", "abc"), a.input('b'));
        Assert.assertEquals(Arrays.asList("abc"), a.input('c'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));
        Assert.assertEquals(Arrays.asList("abc", "a", "abbc"), a.input('a'));
        Assert.assertEquals(Arrays.asList("abc", "abbc"), a.input('b'));
        Assert.assertEquals(Arrays.asList("abc"), a.input('c'));
        Assert.assertEquals(new ArrayList<>(), a.input('#'));
    }
}