package greedy.RemoveDuplicateLetters_316;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("abc", s.removeDuplicateLetters("bcabc"));
        assertEquals("acdb", s.removeDuplicateLetters("cbacdcbc"));
        assertEquals("abcdef", s.removeDuplicateLetters("abcdef"));
        assertEquals("abcdefghijklnorsu", s.removeDuplicateLetters("bcabcsdfasdkjghdlkghnkghnldkuhgldkfhgnlksahfnaklhfgnfskdfanhlkasasfsjfgjasiofghhisadlugherluighlsibcabcsdfasdkjghdlkghnkghnldkuhgldkfhgnlksahfnaklhfgnfskdfanhlkasasfsjfgjasiofghhisadlugherluighlsibcabcsdfasdkjghdlkghnkghnldkuhgldkfhgnlksahfnaklhfgnfskdfanhlkasasfsjfgjasiofghhisadlugherluighlsibcabcsdfasdkjghdlkghnkghnldkuhgldkfhgnlksahfnaklhfgnfskdfanhlkasasfsjfgjasiofghhisadlugherluighlsibcabcsdfasdkjghdlkghnkghnldkuhgldkfhgnlksahfnaklhfgnfskdfanhlkasasfsjfgjasiofghhisadlugherluighlsibcabcsdfasdkjghdlkghnkghnldkuhgldkfhgnlksahfnaklhfgnfskdfanhlkasasfsjfgjasiofghhisadlugherluighlsi"));
    }
}