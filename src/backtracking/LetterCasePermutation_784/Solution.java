package backtracking.LetterCasePermutation_784;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 *
 * Examples:
 *
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 *
 *  Note:
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class Solution {
    // DFS
    // tc O(logn), sc O(2^n)
    List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        backtrack(s.toCharArray(), list, 0);
        return list;
    }

    private void backtrack(char[] str, List<String> list, int i) {
        while (i < str.length && str[i] >= '0' && str[i] <= '9') {
            i++;
        }
        if (i == str.length) {
            list.add(new String(str));
            return;
        }
        str[i] = Character.toLowerCase(str[i]);
        backtrack(str, list, i + 1);
        str[i] = Character.toUpperCase(str[i]);
        backtrack(str, list, i + 1);
    }
}
