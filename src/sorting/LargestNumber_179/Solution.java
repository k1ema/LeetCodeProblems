package sorting.LargestNumber_179;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    // 10 ms, faster than 28.70%; 38.9 MB, less than 88.88%
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] s = IntStream.of(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(s, (a, b) -> {
            String s1 = a + b, s2 = b + a;
            return s2.compareTo(s1);
        });
        if (s[0].equals("0")) return "0";
        return Stream.of(s).reduce(String::concat).get();
    }
}
