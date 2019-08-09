package slidingWindow.FindAllAnagramsInAString_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s
 * and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Solution {
    // https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
    // tc O(n), n = s.length()
    // 12 ms
    List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        int[] sc = new int[26];
        int[] pc = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sc[s.charAt(i) - 'a']++;
            pc[p.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = p.length(); i <= s.length(); i++) {
            if (compare(sc, pc)) {
                result.add(i - p.length());
            }


            sc[s.charAt(i - p.length()) - 'a']--;
            if (i < s.length()) {
                sc[s.charAt(i) - 'a']++;
            }
        }

        return result;
    }

    private boolean compare(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    // https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
    // 25 ms
    // tc O(n), n = s.lengtn()
    // sc O(t)
    List<Integer> findAnagrams2(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }

    // my solution, 372 ms
    // tc O(n*m), where n = s.length(), m = p.length()
    // sc O(n)
    List<Integer> findAnagrams1(String s, String p) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        int[] a = new int[26];
        for (int i = 0; i < p.length(); i++) {
            a[p.charAt(i) - 'a']++;
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int start = i;
            int end = start + p.length();
            int[] tmp = Arrays.copyOf(a, a.length);
            while (start < end) {
                tmp[s.charAt(start) - 'a']--;
                start++;
            }
            boolean isOk = true;
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] != 0) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) result.add(i);
        }

        return result;
    }
}
