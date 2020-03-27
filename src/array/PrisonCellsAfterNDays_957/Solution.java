package array.PrisonCellsAfterNDays_957;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 957. Prison Cells After N Days
 * https://leetcode.com/problems/prison-cells-after-n-days/
 *
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell
 * becomes occupied. Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have
 * two adjacent neighbors.)
 *
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th
 * cell is occupied, else cells[i] == 0.
 *
 * Given the initial state of the prison, return the state of the prison after N days (and N
 * such changes described above.)
 *
 * Example 1:
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 *
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * Example 2:
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 *
 * Note:
 * cells.length == 8
 * cells[i] is in {0, 1}
 * 1 <= N <= 10^9
 */
public class Solution {
    // tc O(2^n), sc O(2^n * n), where n - number of cells in prison
    // 4 ms, faster than 34.48%; 40 MB, less than 7.14%
    // https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14
    int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N > 0) {
            map.put(Arrays.toString(cells), N--);
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            String s = Arrays.toString(cells);
            if (map.containsKey(s)) {
                N %= map.get(s) - N;
            }
        }
        return cells;
    }

    // tc O(N), sc O(N), TLE
    int[] prisonAfterNDays1(int[] cells, int N) {
        while (N > 0) {
            N--;
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
        }
        return cells;
    }
}
