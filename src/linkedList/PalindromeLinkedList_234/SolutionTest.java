package linkedList.PalindromeLinkedList_234;

import org.junit.jupiter.api.Test;

import static linkedList.utils.Parser.stringToListNode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome(stringToListNode("[1,2,2,1]")));

        s = new Solution();
        assertFalse(s.isPalindrome(stringToListNode("[1,2]")));

        s = new Solution();
        assertTrue(s.isPalindrome(stringToListNode("[1,2,1]")));

        s = new Solution();
        assertTrue(s.isPalindrome(stringToListNode("[1,2,3,4,5,4,3,2,1]")));

        s = new Solution();
        assertFalse(s.isPalindrome(stringToListNode("[1,0,0]")));
    }
}
