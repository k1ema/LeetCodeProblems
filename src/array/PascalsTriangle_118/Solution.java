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
        if (numRows == 0) return new ArrayList<>();
        List<List<Integer>> resultList = new LinkedList<>();
        int[][] result = new int[numRows][];
        result[0] = new int[1];
        result[0][0] = 1;
        resultList.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            int[] row = new int[i + 1];
            List<Integer> rowList = new LinkedList<>();
            row[0] = 1;
            row[i] = 1;
            rowList.add(1);
            for (int j = 1; j < i; j++) {
                row[j] = result[i - 1][j - 1] + result[i - 1][j];
                rowList.add(j, row[j]);
            }
            rowList.add(1);
            result[i] = row;
            resultList.add(rowList);
        }
        return resultList;
    }

    List<List<Integer>> generate2(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> prevRow = result.get(i - 1);
                row.add(j, prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
