package array.PascalsTriangle_118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Solution {
    // https://leetcode.com/problems/pascals-triangle/discuss/38141/My-concise-solution-in-Java
    List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<>(row));
        }
        return allrows;
    }

    // tc O(n^2), sc O(n^2)
    List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i <= numRows; i++) {
            rows.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    rows.get(i).add(1);
                } else {
                    int v = rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j);
                    rows.get(i).add(v);
                }
            }
        }
        return rows;
    }
}
