package graph.AlienDictionary_269;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 269. Alien Dictionary
 * https://leetcode.com/problems/alien-dictionary/
 *
 * There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.
 *
 * You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 *
 * Derive the order of letters in this language, and return it. If the given input is invalid, return "". If there are multiple valid solutions, return any of them.
 *
 * Example 1:
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 *
 * Example 2:
 * Input: words = ["z","x"]
 * Output: "zx"
 *
 * Example 3:
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 *
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of only lowercase English letters.
 */
public class Solution {
    // DFS, tc O(m * n), sc O(m * n)
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1], w2 = words[i];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c2).add(c1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] state = new int[26];
        for (char c : graph.keySet()) {
            if (state[c - 'a'] == 0) {
                if (!dfs(graph, c, sb, state)) return "";
            }
        }

        return sb.toString();
    }

    private boolean dfs(Map<Character, List<Character>> graph, char u, StringBuilder sb, int[] state) {
        if (state[u - 'a'] == 1) return false; // cycle detected
        state[u - 'a'] = 1;
        for (char v : graph.get(u)) {
            if (state[v - 'a'] < 2) {
                if (!dfs(graph, v, sb, state)) return false;
            }
        }
        state[u - 'a'] = 2;
        sb.append(u);
        return true;
    }

    // BFS
    public String alienOrder1(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    counts.put(c2, counts.get(c2) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : counts.keySet()) {
            if (counts.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.remove();
            sb.append(c);
            for (Character next : graph.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }

        if (sb.length() < counts.size()) return "";

        return sb.toString();
    }
}
