package string.ReverseString_344;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 *  Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 */
public class Main {
    private static final char[][] DATA = {
            {'h', 'e', 'l', 'l', 'o'},
            {'h'},
            {'h', 'e'},
            {'H', 'a', 'n', 'n', 'a', 'h'},
            {}
    };

    public static void main(String[] args) {
        Main m = new Main();
        for (char[] s : DATA) {
            m.reverseString(s);
            System.out.println(s);
        }
    }

    // O(n)
    private void reverseString(char[] s) {
        int m = s.length / 2;
        for (int i = 0; i < m; i++) {
            swap(s, i, s.length - i - 1);
        }
    }

    private void swap(char[] s, int i1, int i2) {
        char tmp = s[i1];
        s[i1] = s[i2];
        s[i2] = tmp;
    }
}
