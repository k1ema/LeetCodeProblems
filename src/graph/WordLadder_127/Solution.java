package graph.WordLadder_127;

import javafx.util.Pair;

import java.util.*;

public class Solution implements ISolution {
    // tc O(m^2 * n), where m = word.length and n = # of words in wordList
    // sc O(m * n) we have a queue which may contain up to wordList size and for each word we allocate char[] for word
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) return 0;

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                char[] word_chars = word.toCharArray();
                for (int i = 0; i < word_chars.length; i++) {
                    char original = word_chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        word_chars[i] = c;
                        String newWord = String.valueOf(word_chars);
                        if (newWord.equals(endWord)) return level + 1;
                        if (wordDict.contains(newWord)) {
                            queue.offer(newWord);
                            wordDict.remove(newWord);
                        }
                    }
                    word_chars[i] = original;
                }
            }
            level++;
        }
        return 0;
    }

    // tc O(m^2 * n), m - word length, n - wordList size; sc O(m * n)
    // 40 ms, faster than 88.87%; 47.1 MB, less than 32.44%
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
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
}
