package math.ReconstructOriginalDigitsFromEnglish_423;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 423. Reconstruct Original Digits from English
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 *
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 *
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 *
 * Example 1:
 * Input: "owoztneoer"
 * Output: "012"
 *
 * Example 2:
 * Input: "fviefuro"
 * Output: "45"
 */
public class Solution {
    public String originalDigits(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] digits = new int[10];
        digits[0] = freq['z' - 'a'];
        digits[2] = freq['w' - 'a'];
        digits[4] = freq['u' - 'a'];
        digits[6] = freq['x' - 'a'];
        digits[8] = freq['g' - 'a'];
        digits[5] = Math.max(0, freq['f' - 'a'] - digits[4]);
        digits[1] = Math.max(0, freq['o' - 'a'] - digits[0] - digits[2] - digits[4]);
        digits[3] = Math.max(0, freq['r' - 'a'] - digits[0] - digits[4]);
        digits[7] = Math.max(0, freq['v' - 'a'] - digits[5]);
        digits[9] = Math.max(0, freq['i' - 'a'] - digits[5] - digits[6] - digits[8]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            while (digits[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    private final static List<Pair<String, Integer>> digits = List.of(new Pair<>("zero", 0), new Pair<>("two", 2),
            new Pair<>("four", 4), new Pair<>("five", 5), new Pair<>("six", 6), new Pair<>("seven", 7),
            new Pair<>("three", 3), new Pair<>("eight", 8), new Pair<>("one", 1), new Pair<>("nine", 9));
    public String originalDigits1(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < digits.size(); i++) {
            processWord(digits.get(i).getKey(), digits.get(i).getValue(), freq, map);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : map.keySet()) {
            int count = map.get(num);
            while (count-- > 0) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    private void processWord(String s, int num, int[] freq, Map<Integer, Integer> map) {
        int count = 50000;
        for (int i = 0; i < s.length(); i++) {
            count = Math.min(count, freq[s.charAt(i) - 'a']);
        }
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] -= count;
        }
        map.put(num, count);
    }
}
