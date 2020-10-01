package stack.BasicCalculator_II_227;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators
 * and empty spaces. The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 *
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 *
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 *
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class Solution {
    // tc O(n), sc O(n)
    // 9 ms, faster than 76.85%; 39.5 MB, less than 84.12%
    public int calculate(String s) {
        if (s == null) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    // without stack
    // tc O(n), sc O(1)
    int calculate1(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (sign) {
                    case '+':
                        sum += tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum += tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                num = 0;
                sign = s.charAt(i);
            }
        }

        sum += tempSum;
        return sum;
    }
}