package hashtable.ValidAnagram_242;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Solution {
    // tc O(n), sc O(n)
    boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            a[ss[i] - 'a']++;
            a[tt[i] - 'a']--;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // tc O(n+m), sc O(n)
    boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        List<String> l = new LinkedList<>(Arrays.asList(s.split("")));
        String[] tt = t.split("");
        for (int i = 0; i < tt.length; i++) {
            l.remove(tt[i]);
        }
        return l.isEmpty();
    }
}
