package backtracking.LetterCombinationsOfAPhoneNumber_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
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
    // 1 ms, faster than 57.23%; 36.3 MB, less than 98.63%
    private final static Map<Character, String> map = new HashMap<>();
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
        if (digits == null || "".equals(digits.trim())) return result;
        for (int i = 0; i < map.get(digits.charAt(0)).length(); i++) {
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
            for (int i = 0; i < map.get(digits.charAt(di + 1)).length(); i++) {
                bt(result, sb, di + 1, i, digits);
                sb.delete(di + 1, sb.length());
            }
        }
    }
}
