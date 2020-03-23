package string.RansomNote_383;

/**
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/
 *
 * Given an arbitrary ransom note string and another string containing letters from all the
 * magazines, write a function that will return true if the ransom note can be constructed
 * from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Solution {
    // tc O(m), sc O(1), m - magazine.length()
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null) return false;
        if (ransomNote == null) return true;
        int[] a = new int[26];
        for (int i=0; i < magazine.length(); i++) {
            a[magazine.charAt(i) - 'a']++;
        }
        for (int i=0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (a[c - 'a'] == 0) return false;
            else a[c - 'a']--;
        }
        return true;
    }
}
