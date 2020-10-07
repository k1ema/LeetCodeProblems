package graph.WordLadder_127;

import javafx.util.Pair;

import java.util.*;

public class BidirectionalSolution implements ISolution {
    // https://leetcode.com/articles/word-ladder/
    // tc O(m^2 * n), m - word length, n - wordList size; sc O(m * n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> dict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String s = word.substring(0, i) + '*' + word.substring(i + 1);
                dict.putIfAbsent(s, new ArrayList<>());
                dict.get(s).add(word);
            }
        }

        Queue<Pair<String, Integer>> q_begin = new LinkedList<>();
        Queue<Pair<String, Integer>> q_end = new LinkedList<>();
        q_begin.add(new Pair<>(beginWord, 1));
        q_end.add(new Pair<>(endWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!q_begin.isEmpty() && !q_end.isEmpty()) {
            // One hop from begin word
            int ans = visitWordNode(q_begin, visitedBegin, visitedEnd, dict);
            if (ans > -1) {
                return ans;
            }

            // One hop from end word
            ans = visitWordNode(q_end, visitedEnd, visitedBegin, dict);
            if (ans > -1) {
                return ans;
            }
        }

        return 0;
    }

    private int visitWordNode(Queue<Pair<String, Integer>> queue, Map<String, Integer> visited,
                              Map<String, Integer> othersVisited, Map<String, List<String>> dict) {
        Pair<String, Integer> node = queue.remove();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < word.length(); i++) {
            // Intermediate words for current word
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1);

            // Next states are all the words which share the same intermediate state.
            for (String adjacentWord : dict.getOrDefault(newWord, new ArrayList<>())) {
                // If at any point if we find what we are looking for
                // i.e. the end word - we can return with the answer.
                if (othersVisited.containsKey(adjacentWord)) {
                    return level + othersVisited.get(adjacentWord);
                }

                if (!visited.containsKey(adjacentWord)) {

                    // Save the level as the value of the dictionary, to save number of hops.
                    visited.put(adjacentWord, level + 1);
                    queue.add(new Pair<>(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }
}
