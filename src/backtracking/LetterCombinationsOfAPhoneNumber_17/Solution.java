package backtracking.LetterCombinationsOfAPhoneNumber_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that
 * 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
    // tc O(3^n*4^m), sc O((3^n*4^m), where N is the number of digits in the input that maps
    // to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps
    // to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.
    //
    // 0 ms, faster than 100.00%, 36.2 MB, less than 98.63%
    private static final Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.trim().isEmpty()) return result;
        int len = map.get(digits.charAt(0)).length();
        for (int i = 0; i < len; i++) {
            bt(result, new StringBuilder(), 0, i, digits);
        }
        return result;
    }

    private void bt(List<String> result, StringBuilder sb, int di, int li, String digits) {
        if (di == digits.length() || li == map.get(digits.charAt(di)).length()) return;

        sb.append(map.get(digits.charAt(di)).charAt(li));
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
        } else {
            String nextLetters = map.get(digits.charAt(di + 1));
            for (int i = 0; i < nextLetters.length(); i++) {
                bt(result, sb, di + 1, i, digits);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private final String[][] ss = new String[][] {
            {""},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };

    // semaserg
    List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.trim().isEmpty()) return result;
        backtrack(result, 0, new ArrayList<>(), digits);
        return result;
    }

    private void backtrack(List<String> result, int index, List<String> current, String digits) {
        if (index == digits.length()) {
            result.add(String.join("", current));
            return;
        }
        int d = digits.charAt(index) - '0' - 1;
        for (String s : ss[d]) {
            current.add(s);
            backtrack(result, index + 1, current, digits);
            current.remove(current.size() - 1);
        }
    }

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
    List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}
