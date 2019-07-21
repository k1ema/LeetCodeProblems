package string.GroupAnagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class Solution {
    // https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
    // tc O(strs.len * nlogn), sc O(n)
    List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // in solution
    List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] a = new int[26];
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                a[chars[i] - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(a[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
//            map.computeIfAbsent(s, f -> new LinkedList<>()).add(str); // computes 48ms vs 17ms with classic containsKey/get/add
        }
        return new ArrayList<>(map.values());
    }

    // tc O(), sc O(n), my solution, time limit exceeded
    List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            boolean contains = false;
            for (String mapKey : map.keySet()) {
                if (isAnagram(str, mapKey)) {
                    map.get(mapKey).add(str);
                    contains = true;
                }
            }
            if (!contains) {
                map.computeIfAbsent(str, f -> new LinkedList<>()).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    // tc O(n), sc O(n)
    private boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            a[ss[i] - 'a']++;
            a[tt[i] - 'a']--;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
