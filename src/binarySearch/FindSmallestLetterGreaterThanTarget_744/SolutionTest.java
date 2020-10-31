package binarySearch.FindSmallestLetterGreaterThanTarget_744;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals('c', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a'));
        assertEquals('f', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c'));
        assertEquals('f', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'd'));
        assertEquals('j', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'g'));
        assertEquals('c', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'j'));
        assertEquals('c', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'k'));
    }
}