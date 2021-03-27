package stack.BasicCalculator_III_772;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 772. Basic Calculator III
 * https://leetcode.com/problems/basic-calculator-iii/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, '+', '-', '*', '/' operators, and open '('
 * and closing parentheses ')'. The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2^31, 2^31 - 1].
 *
 * Example 1:
 * Input: s = "1+1"
 * Output: 2
 *
 * Example 2:
 * Input: s = "6-4/2"
 * Output: 4
 *
 * Example 3:
 * Input: s = "2*(5+5*2)/3+(6/2+8)"
 * Output: 21
 *
 * Example 4:
 * Input: s = "(2+6*3+5-(3*14/7+2)*5)+3"
 * Output: -12
 *
 * Example 5:
 * Input: s = "0"
 * Output: 0
 *
 * Constraints:
 * 1 <= s <= 10^4
 * s consists of digits, '+', '-', '*', '/', '(', and ')'.
 * s is a valid expression.
 *
 * Follow up: Could you solve the problem without using built-in library functions?
 */
public class Solution {
    // tc O(n), sc O(n)
    // 8 ms, faster than 21.16%; 39.7 MB, less than 13.26%
    public int calculate(String s) {
        Queue<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            q.add(c);
        }
        q.add('+');
        return calculate(q);
    }

    private int calculate(Queue<Character> q) {
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = calculate(q);
            } else {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
                if (c == ')') break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    // my solution
    // tc O(n), sc O(n)
    // 4 ms, faster than 62.80%; 39.3 MB, less than 26.77%
    public int calculate1(String s) {
        return calculate(s, 0)[0];
    }

    private int[] calculate(String s, int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0, i = start;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int[] nums = calculate(s, i + 1);
                num = nums[0];
                i = nums[1] + 1;
            }

            if (i >= s.length() - 1 || !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                num = 0;
                if (i < s.length()) sign = s.charAt(i);
                if (sign == ')') break;
            }
            i++;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return new int[] {res, i};
    }
}
