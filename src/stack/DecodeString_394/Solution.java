package stack.DecodeString_394;

import javafx.util.Pair;

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
    private int pos = 0;
    // tc O(n), sc O(n)
    // https://leetcode.com/problems/decode-string/discuss/87615/Simple-Java-DFS-Solution
    String decodeString(String s) {
        String num = "";
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
            } else if (s.charAt(i) == '[') {
                pos = i + 1;
                String sub = decodeString(s);
                int v = Integer.parseInt(num);
                for (int j = 0; j < v; j++) {
                    sb.append(sub);
                }
                i = pos;
                num = "";
            } else if (s.charAt(i) == ']') {
                pos = i;
                return sb.toString();
            } else {
                sb.append(s.charAt(i));
            }
        }
        pos = 0; // for next test
        return sb.toString();
    }

    // tc O(n), sc O(n)
    String decodeString1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                Pair<String, Integer> pair = decodeBracket(i, s);
                sb.append(pair.getKey());
                i = pair.getValue();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * Decodes string starting from number
     * @param start index of number
     * @param s input string
     * @return key - decoded string, value - index of closed bracket
     */
    private Pair<String, Integer> decodeBracket(int start, String s) {
        int openBracket = s.indexOf('[', start);
        int v = Integer.parseInt(s.substring(start, openBracket));
        StringBuilder sb = new StringBuilder();
        for (int i = openBracket + 1; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String sub = sb.toString();
                for (int j = 1; j < v; j++) {
                    sb.append(sub);
                }
                return new Pair<>(sb.toString(), i);
            }
            if (Character.isDigit(s.charAt(i))) {
                Pair<String, Integer> pair = decodeBracket(i, s);
                sb.append(pair.getKey());
                i = pair.getValue();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return null;
    }
}
