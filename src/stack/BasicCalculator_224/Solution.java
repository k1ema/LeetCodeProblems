package stack.BasicCalculator_224;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. Basic Calculator
 * https://leetcode.com/problems/basic-calculator/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or
 * minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 * Input: "1 + 1"
 * Output: 2
 *
 * Example 2:
 * Input: " 2-1 + 2 "
 * Output: 3
 *
 * Example 3:
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class Solution {
    // tc O(n), sc O(n)
    // 7 ms, faster than 68.06%; 39.4 MB, less than 86.41%
    public int calculate(String s) {
        if (s == null) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0, num = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                res += sign * num;
                num = 0;

                switch (c) {
                    case '+' -> sign = 1;
                    case '-' -> sign = -1;
                    case '(' -> {
                        stack.push(res);
                        stack.push(sign);
                        res = 0;
                        sign = 1;
                    }
                    case ')' -> res = stack.pop() * res + stack.pop();
                }
            }
        }
        return res;
    }
}
