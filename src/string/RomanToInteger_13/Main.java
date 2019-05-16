package string.RomanToInteger_13;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII,
 * which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to
 * the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 * Input: "III"
 * Output: 3
 *
 *  Example 2:
 * Input: "IV"
 * Output: 4
 *
 *  Example 3:
 * Input: "IX"
 * Output: 9
 *
 *  Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 *  Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class Main {
    private static final String[] DATA = {
            "III",
            "IV",
            "IX",
            "LVIII",
            "MCMXCIV"
    };

    public static void main(String[] args) {
        Main m = new Main();
        for (String s : DATA) {
            int i = m.romanToInt(s);
            System.out.println(i);
        }
    }

    // O(n)
    private int romanToInt(String s) {
        Map<String, Integer> m = new HashMap<>();
        m.put("I", 1);
        m.put("V", 5);
        m.put("X", 10);
        m.put("L", 50);
        m.put("C", 100);
        m.put("D", 500);
        m.put("M", 1000);

        Map<String, Integer> subtractions = new HashMap<>();
        subtractions.put("IV", 4);
        subtractions.put("IX", 9);
        subtractions.put("XL", 40);
        subtractions.put("XC", 90);
        subtractions.put("CD", 400);
        subtractions.put("CM", 900);

        int result = 0;
        char[] chars = s.toCharArray();
        int pointer = 0;
        while (pointer < chars.length) {
            if (pointer + 1 < chars.length) {
                String ss = "" + chars[pointer] + chars[pointer + 1];
                if (subtractions.containsKey(ss)) {
                    result += subtractions.get(ss);
                    pointer += 2;
                } else {
                    result += m.get("" + chars[pointer++]);
                }
            } else {
                result += m.get("" + chars[pointer++]);
            }
        }
        return result;
    }
}
