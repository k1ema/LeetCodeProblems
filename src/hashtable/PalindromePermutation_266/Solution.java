package hashtable.PalindromePermutation_266;

import java.util.HashMap;
import java.util.Map;

/**
 * 266. Palindrome Permutation
 * https://leetcode.com/problems/palindrome-permutation/
 *
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 * Input: "code"
 * Output: false
 *
 * Example 2:
 * Input: "aab"
 * Output: true
 *
 * Example 3:
 * Input: "carerac"
 * Output: true
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (int freq : map.values()) {
            if (freq % 2 == 1) odd++;
        }
        return odd <= 1;
    }
}
