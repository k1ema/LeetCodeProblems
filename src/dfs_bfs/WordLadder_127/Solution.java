package dfs_bfs.WordLadder_127;

import javafx.util.Pair;

import java.util.*;

public class Solution implements ISolution {
    // tc O(m^2 * n), where m = word.length and n = # of words in wordList
    // sc O(m * n) we have a queue which may contain up to wordList size and for each word we allocate char[] for word
    // 51 ms, faster than 73.47%; 40.8 MB, less than 62.67%
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                String w = q.poll();
                if (w.equals(endWord)) return count;
                char[] chars = w.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char origChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == origChar) continue;
                        chars[j] = c;
                        String newWord = String.valueOf(chars);
                        if (dict.contains(newWord)) {
                            q.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                    chars[j] = origChar;
                }
            }
        }
        return 0;
    }

    // tc O(m^2 * n), m - word length, n - wordList size; sc O(m^2 * n)
    // 52 ms, faster than 71.23%; 47 MB, less than 22.68%
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Map<String, List<String>> graph = new HashMap<>();
        for (String w : wordList) {
            for (int i = 0; i < w.length(); i++) {
                String key = w.substring(0, i) + '*' + w.substring(i + 1);
                graph.putIfAbsent(key, new ArrayList<>());
                graph.get(key).add(w);
            }
        }

        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                String w = q.poll();
                if (w.equals(endWord)) return count;
                for (int j = 0; j < w.length(); j++) {
                    String key = w.substring(0, j) + '*' + w.substring(j + 1);
                    if (!graph.containsKey(key)) continue;
                    for (String newWord : graph.get(key)) {
                        if (!newWord.equals(w) && dict.contains(newWord)) {
                            q.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    // tc O(m^2 * n), m - word length, n - wordList size; sc O(m * n)
    // 40 ms, faster than 88.87%; 47.1 MB, less than 32.44%
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String s = word.substring(0, i) + '*' + word.substring(i + 1);
                map.putIfAbsent(s, new ArrayList<>());
                map.get(s).add(word);
            }
        }

        Deque<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();

            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                for (String newWord : map.getOrDefault(pattern, new ArrayList<>())) {
                    if (newWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(newWord)) {
                        queue.add(new Pair<>(newWord, level + 1));
                        visited.add(newWord);
                    }
                }
            }
        }

        return 0;
    }

    // Wrong answer
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        int res = f(beginWord, endWord, dict, new HashSet<>(), new HashMap<>());
        return res == 1e9 ? 0 : res;
    }

    private int f(String begin, String end, Set<String> dict, Set<String> used, Map<String, Integer> memo) {
        if (begin.equals(end)) {
            return 1;
        }
        if (memo.containsKey(begin)) {
            return memo.get(begin);
        }
        int res = (int) 1e9;
        used.add(begin);
        for (int i = 0; i < begin.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                String newWord = begin.substring(0, i) + c + begin.substring(i + 1);
                if (!newWord.equals(begin) && dict.contains(newWord) && !used.contains(newWord)) {
                    res = Math.min(res, 1 + f(newWord, end, dict, used, memo));
                }
            }
        }
        used.remove(begin);
        memo.put(begin, res);
        return res;
    }

}
