package stack.DecodeString_394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets
 * are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Solution {
    // tc O(n), sc O(n)
    // Time Complexity: O(maxK⋅n), where maxK is the maximum value of k and n is the length of a given string s.
    // We traverse a string of size n and iterate k times to decode each pattern of form k[string]. This gives us
    // worst case time complexity as O(maxK⋅n).
    // Space Complexity: O(m+n), where m is the number of letters(a-z) and n is the number of digits(0-9) in string s.
    // In worst case, the maximum size of stringStack and countStack could be m and n respectively.
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                stack.push(sb.toString());
                stack.push("" + num);
                sb = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int curNum = Integer.parseInt(stack.poll());
                String prevString = stack.poll();
                String curString = sb.toString();
                while (curNum-- > 1) {
                    sb.append(curString);
                }
                sb.insert(0, prevString);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
