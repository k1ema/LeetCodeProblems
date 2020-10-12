package string.BuddyStrings_859;

import java.util.Arrays;

/**
 * 859. Buddy Strings
 * https://leetcode.com/problems/buddy-strings/
 *
 * Given two strings A and B of lowercase letters, return true if you can
 * swap two letters in A so the result is equal to B, otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such
 * that i != j and swapping the characters at A[i] and A[j]. For example,
 * swapping at indices 0 and 2 in "abcd" results in "cbad".
 *
 * Example 1:
 * Input: A = "ab", B = "ba"
 * Output: true
 * Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
 *
 * Example 2:
 * Input: A = "ab", B = "ab"
 * Output: false
 * Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
 *
 * Example 3:
 * Input: A = "aa", B = "aa"
 * Output: true
 * Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
 *
 * Example 4:
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 *
 * Example 5:
 * Input: A = "", B = "aa"
 * Output: false
 *
 * Constraints:
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist of lowercase letters.
 */
public class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int[] freqA = new int[26];
        int[] freqB = new int[26];
        int diffCount = 0;
        for (int i = 0; i < A.length(); i++) {
            char ca = A.charAt(i);
            char cb = B.charAt(i);
            if (ca != cb) diffCount++;
            freqA[ca - 'a']++;
            freqB[cb - 'a']++;
        }
        if (Arrays.compare(freqA, freqB) != 0) return false;
        if (diffCount >= 2) return diffCount == 2;
        // diffCount == [0 or 1]
        for (int i = 0; i < 26; i++) {
            if (freqA[i] > 1) return true;
        }
        return false;
    }
}
