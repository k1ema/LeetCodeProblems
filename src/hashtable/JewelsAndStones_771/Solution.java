package hashtable.JewelsAndStones_771;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/
 *
 * You're given strings J representing the types of stones that are jewels, and S
 * representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
class Solution {
    int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.toCharArray()[i]);
        }
        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.toCharArray()[i])) {
                counter++;
            }
        }
        return counter;
    }

    // from leetcode
    int numJewelsInStones1(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}
