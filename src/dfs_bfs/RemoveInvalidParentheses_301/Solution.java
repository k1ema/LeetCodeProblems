package dfs_bfs.RemoveInvalidParentheses_301;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * Remove the minimum number of invalid parentheses in order to make the input string
 * valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 *
 * Example 2:
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 *
 * Example 3:
 * Input: ")("
 * Output: [""]
 */
public class Solution {
    // BFS, tc O(n*2^n), sc O(2^n)?
    // 50 ms, faster than 41.73%; 41 MB, less than 26.91%
    // https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            String str = q.poll();

            if (isValid(str)) {
                res.add(str);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != '(' && c != ')') continue;
                String substr = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(substr)) {
                    q.add(substr);
                    visited.add(substr);
                }
            }
        }

        return res;
    }

    private boolean isValid(String s) {
        int bal = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') bal++;
            else if (c == ')') bal--;
            if (bal < 0) return false;
        }
        return bal == 0;
    }

    // my solution
    public List<String> removeInvalidParentheses3(String s) {
        List<String> list = new ArrayList<>();
        helper(s, 0, 0, new StringBuilder(), list);
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        Collections.sort(list, (a, b) -> b.length() - a.length());
        Set<String> res = new HashSet<>();
        res.add(list.get(0));
        int len = list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() < len) {
                break;
            }
            res.add(list.get(i));
        }
        return new ArrayList<>(res);
    }

    private void helper(String s, int i, int balance, StringBuilder sb, List<String> list) {
        if (balance < 0) {
            return;
        }
        if (i == s.length()) {
            if (balance == 0) {
                list.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(i);
        if (c == '(' || c == ')') {
            int size = sb.length();
            sb.append("" + c);
            helper(s, i + 1, c == '(' ? balance + 1 : balance - 1, sb, list);
            sb.delete(size, sb.length());

            helper(s, i + 1, balance, sb, list);
        } else {
            sb.append("" + c);
            helper(s, i + 1, balance, sb, list);
        }
    }

    // DFS
    // tc O(n*2^n) - n for converting sb to string, sc O(n)
    // 1 ms, faster than 99.96%; 38.1 MB, less than 96.72%
    public List<String> removeInvalidParentheses1(String s) {
        int openRem = 0, closeRem = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openRem++;
            } else if (c == ')') {
                if (openRem == 0) closeRem++;
                if (openRem > 0) openRem--;
            }
        }
        List<String> res = new ArrayList<>();
        bt(s, 0, 0, openRem, closeRem, res, new StringBuilder());
        return res;
    }

    private void bt(String s, int idx, int bal, int openRem, int closeRem, List<String> res, StringBuilder sb) {
        if (idx == s.length()) {
            if (bal == 0 && openRem == 0 && closeRem == 0) {
                res.add(sb.toString());
            }
            return;
        }
        if (bal < 0 || openRem < 0 || closeRem < 0) return;

        char c = s.charAt(idx);
        int len = sb.length();
        if (c != '(' && c != ')') {
            sb.append(c);
            bt(s, idx + 1, bal, openRem, closeRem, res, sb);
            sb.setLength(len);
            return;
        }

        int i = 1;
        while (idx + i < s.length() && s.charAt(idx + i) == c) i++;
        if (c == '(') {
            bt(s, idx + i, bal, openRem - i, closeRem, res, sb);
            sb.append(c);
            bt(s, idx + 1, bal + 1, openRem, closeRem, res, sb);
        } else {
            bt(s, idx + i, bal, openRem, closeRem - i, res, sb);
            sb.append(c);
            bt(s, idx + 1, bal - 1, openRem, closeRem, res, sb);
        }

        sb.setLength(len);
    }

    // solution can be simpler but should be set instead of list
    public List<String> removeInvalidParentheses2(String s) {
        int openRem = 0, closeRem = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openRem++;
            } else if (c == ')') {
                if (openRem == 0) closeRem++;
                if (openRem > 0) openRem--;
            }
        }
        Set<String> res = new HashSet<>();
        bt(s, 0, 0, openRem, closeRem, res, new StringBuilder());
        return new ArrayList<>(res);
    }

    private void bt(String s, int idx, int bal, int openRem, int closeRem, Set<String> res, StringBuilder sb) {
        if (idx == s.length()) {
            if (bal == 0 && openRem == 0 && closeRem == 0) {
                res.add(sb.toString());
            }
            return;
        }
        if (bal < 0 || openRem < 0 || closeRem < 0) return;

        char c = s.charAt(idx);
        int len = sb.length();
        if (c != '(' && c != ')') {
            sb.append(c);
            bt(s, idx + 1, bal, openRem, closeRem, res, sb);
            sb.setLength(len);
            return;
        }

        if (c == '(') {
            bt(s, idx + 1, bal, openRem - 1, closeRem, res, sb);
            sb.append(c);
            bt(s, idx + 1, bal + 1, openRem, closeRem, res, sb);
        } else {
            bt(s, idx + 1, bal, openRem, closeRem - 1, res, sb);
            sb.append(c);
            bt(s, idx + 1, bal - 1, openRem, closeRem, res, sb);
        }

        sb.setLength(len);
    }
}
