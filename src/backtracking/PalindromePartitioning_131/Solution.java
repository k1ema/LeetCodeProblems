package backtracking.PalindromePartitioning_131;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Solution {
    // tc O(n^2 * 2^n) ? (n^2 because we have a loop of n elements and for each element we run isPalindrome method which is O(n) and backtrack further)
    // sc O(n)
    /*
    https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java%3A-Backtracking-solution
    in comments there is bephrem explanation of number of result strings

    all decompositions of a string ≠ all the sub-strings of a string
    The number of substrings of a string is n(n+1)/2. There are 2^(n-1) decompositions of a string (no constraints on how we decompose the string, we just break the string up however we choose as long as we exhaust all possibilities).

    Example:
    n = 3
    "abc"

    Substrings: (3)((3)+1)/2 = 6
    [ "a", "b", "c", "ab", "bc", "abc" ]

    Decompositions: 2^((3)-1) = 4
    [ [ "a", "b", "c" ], [ "a", "bc" ], [ "ab" ,"c"], [ "abc" ] ]

    ...wait...why 2^(n-1) decompositions. Well an intuitive explanation is that of CHOICE.

    Remember how for a set of size n we have 2^n subsets? This is because for n elements we can do 2 THINGS, choose that element to put it in the final subset, or NOT choose that element to put it in the final subset.

    Same principle here except we have 2 choices for n - 1 PARTITION POINTS.

    For example:

    n = 3
    "abc"

    I have 2 PARTITION POINTS that I can make 2 choices on: USE IT or DON'T USE IT. So as follows:

    "a | b | c"

    Do you see those split points?

    If I use the first and second I get [ "a", "b", "c"]
    If I use just the first I get [ "a", "bc"]
    If I use just the second I get [ "ab", "c"]
    If I don't use both I get [ "abc"]

    I hope this clears it up. If not keep asking more questions.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) return res;
        partition(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void partition(String s, int start, List<String> curList, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                curList.add(s.substring(start, i + 1));
                partition(s, i + 1, curList, res);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from) != s.charAt(to)) {
                return false;
            }
            from++; to--;
        }
        return true;
    }
}
