package trie.WordSearch_II_212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Just backtracking solution, 496 ms
public class Solution_III {
    List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (bt(board, word, i, j, 0)) {
                        result.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    private boolean bt(char[][] board, String word, int row, int col, int ind) {
        if (ind == word.length()) return true;
        if (row < 0 || col < 0 || row == board.length || col == board[0].length
                || board[row][col] != word.charAt(ind)) return false;
        // mark cell as visited
        board[row][col] = '*';
        boolean res = bt(board, word, row + 1, col, ind + 1)
                || bt(board, word, row - 1, col, ind + 1)
                || bt(board, word, row, col + 1, ind + 1)
                || bt(board, word, row, col - 1, ind + 1);
        // revert cell
        board[row][col] = word.charAt(ind);
        return res;
    }
}
