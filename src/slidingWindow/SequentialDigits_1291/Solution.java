package slidingWindow.SequentialDigits_1291;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 1291. Sequential Digits
 * https://leetcode.com/problems/sequential-digits/
 *
 * An integer has sequential digits if and only if each digit in the number is one more
 * than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have
 * sequential digits.
 *
 * Example 1:
 * Input: low = 100, high = 300
 * Output: [123,234]
 *
 * Example 2:
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 * Constraints:
 * 10 <= low <= high <= 10^9
 */
public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String sample = "123456789";
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int len = lowLen; len <= highLen; len++) {
            for (int i = 0; i <= sample.length() - len; i++) {
                int num = Integer.parseInt(sample.substring(i, i + len));
                if (num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }

    // https://leetcode.com/problems/sequential-digits/discuss/853592/Python-Solution-using-queue-explained
    public List<Integer> sequentialDigits1(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        while (!q.isEmpty()) {
            int num = q.removeFirst();
            if (num > high) break;
            if (num >= low && num <= high) res.add(num);
            int last = num % 10;
            if (last < 9) {
                num = num * 10 + last + 1;
                q.addLast(num);
            }
        }
        return res;
    }
}
