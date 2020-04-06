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
    // tc O(NK), sc O(N) where N - strs length; K - max word length
    // 15 ms, faster than 29.00%; 53.4 MB, less than 5.26%
    List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] word = new char[26];
            for (int i = 0; i < s.length(); i++) {
                word[s.charAt(i) - 'a']++;
            }
            String key = String.valueOf(word);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
    // tc O(NKlogK), sc O(N) where N - strs length; K - max word length
    // 6 ms, faster than 96.85%; 41.8 MB, less than 94.15%
    List<List<String>> groupAnagrams1(String[] strs) {
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
}
