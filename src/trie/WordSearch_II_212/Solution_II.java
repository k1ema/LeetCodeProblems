package trie.WordSearch_II_212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Just backtracking solution, 496 ms
public class Solution_II implements Solution {
    // tc O(w * (m * n) * 4 * 3 ^ (L - 1)) ?, where m,n - dimensions in board, L - max length of string in words
    // sc O(m * n)
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if (board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
        int m = board.length, n = board[0].length;

        for (String word : words) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, word, i, j, 0)) {
                        res.add(word);
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

    private boolean dfs(char[][] board, String word, int i, int j, int ind) {
        if (ind == word.length()) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length
                || board[i][j] != word.charAt(ind)) return false;
        // mark cell as visited
        board[i][j] = '*';
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean res = false;
        for (int[] dir : dirs) {
            res |= dfs(board, word, i + dir[0], j + dir[1], ind + 1);
        }
        // revert cell
        board[i][j] = word.charAt(ind);
        return res;
    }
}
