package string.CheckIfAStringContainsAllBinaryCodesOfSizeK_1461;

import java.util.HashSet;
import java.util.Set;

/**
 * 1461. Check If a String Contains All Binary Codes of Size K
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 *
 * Given a binary string s and an integer k.
 *
 * Return True if any binary code of length k is a substring of s. Otherwise, return False.
 *
 * Example 1:
 * Input: s = "00110110", k = 2
 * Output: true
 * Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found
 * as substrings at indicies 0, 1, 3 and 2 respectively.
 *
 * Example 2:
 * Input: s = "00110", k = 2
 * Output: true
 *
 * Example 3:
 * Input: s = "0110", k = 1
 * Output: true
 * Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
 *
 * Example 4:
 * Input: s = "0110", k = 2
 * Output: false
 * Explanation: The binary code "00" is of length 2 and doesn't exist in the array.
 *
 * Example 5:
 * Input: s = "0000000001011100", k = 4
 * Output: false
 *
 * Constraints:
 * 1 <= s.length <= 5 * 10^5
 * s consists of 0's and 1's only.
 * 1 <= k <= 20
 */
public class Solution {
    // tc O(n*k), sc O(2^k)
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k)) return false;
        Set<String> set = new HashSet<>();
        for (int i = k; i <= s.length(); i++) {
            set.add(s.substring(i - k, i));
        }
        return set.size() == 1 << k;
    }
}
