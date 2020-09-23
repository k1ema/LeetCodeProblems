package backtracking.LetterCasePermutation_784;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/
 *
 * Given a string S, we can transform every letter individually to be lowercase or
 * uppercase to create another string. Return a list of all possible strings we could create.
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
    // tc O(n*2^n), sc O(n) - space for recursion stack
    List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        dfs(s.toCharArray(), list, 0);
        return list;
    }

    private void dfs(char[] str, List<String> list, int i) {
        while (i < str.length && Character.isDigit(str[i])) {
            i++;
        }
        if (i == str.length) {
            list.add(new String(str));
            return;
        }
        str[i] = Character.toLowerCase(str[i]);
        dfs(str, list, i + 1);
        str[i] = Character.toUpperCase(str[i]);
        dfs(str, list, i + 1);
    }

    // BFS
    // tc O(n*2^n), sc O(2^n) - space for result answer
    // https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation
    List<String> letterCasePermutation1(String s) {
        if (s == null || s.isEmpty()) {
            return new LinkedList<>();
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                continue;
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                char[] chars = queue.poll().toCharArray();
                chars[i] = Character.toLowerCase(chars[i]);
                queue.add(String.valueOf(chars));
                chars[i] = Character.toUpperCase(chars[i]);
                queue.add(String.valueOf(chars));
            }
        }
        return new LinkedList<>(queue);
    }
}
