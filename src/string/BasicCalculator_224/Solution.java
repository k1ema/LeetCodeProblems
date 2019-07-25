package string.BasicCalculator_224;

import java.util.Stack;

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
    // https://leetcode.com/problems/basic-calculator/discuss/62362/JAVA-Easy-Version-To-Understand
    // tc O(n), sc O(n)
    int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }

        int num;
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sign * num;
            }

            switch (s.charAt(i)) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case '(':
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                    break;
                case ')':
                    result = stack.pop() * result + stack.pop();
                    break;
            }
        }

        return result;
    }

    // my solution
    // tc O(n), sc O(n)
    int calculate1(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }

        char sign = '+';
        int num = 0;
        int tmpSum = 0;
        Stack<Character> stackSign = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == ')' || i == len - 1) {
                switch (sign) {
                    case '+':
                        tmpSum += num;
                        break;
                    case '-':
                        tmpSum -= num;
                        break;
                }
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    sign = s.charAt(i);
                }
                num = 0;
            }
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (s.charAt(i) == '(') {
                    stackSign.push(sign);
                    sign = '+';
                    stackNum.push(tmpSum);
                    tmpSum = 0;
                } else {
                    char bracketSign = stackSign.pop();
                    if (bracketSign == '-') {
                        tmpSum = stackNum.pop() - tmpSum;
                    } else {
                        tmpSum = stackNum.pop() + tmpSum;
                    }
                }
            }
        }
        tmpSum = sign == '+' ? tmpSum + num : tmpSum - num;
        stackNum.push(tmpSum);

        int sum = 0;
        while (!stackNum.isEmpty()) {
            sum += stackNum.pop();
        }

        return sum;
    }
}
