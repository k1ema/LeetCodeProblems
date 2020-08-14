package hashtable.LongestPalindrome_409;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Solution {
    public int longestPalindrome(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) - 'a';
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        int center = 0;
        for (int value : map.values()) {
            if (value % 2 == 1) {
                res += (value - 1);
                if (center == 0) center = 1;
            } else {
                res += value;
            }
        }
        res += center;
        return res;
    }
}
