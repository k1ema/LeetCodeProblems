package array.CinemaSeatAllocation_1386;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1386. Cinema Seat Allocation
 * https://leetcode.com/problems/cinema-seat-allocation/
 *
 * A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row,
 * labelled from 1 to 10 as shown in the figure above.
 *
 * Given the array reservedSeats containing the numbers of seats already reserved, for
 * example, reservedSeats[i]=[3,8] means the seat located in row 3 and labelled with 8 is
 * already reserved.
 *
 * Return the maximum number of four-person families you can allocate on the cinema seats.
 * A four-person family occupies fours seats in one row, that are next to each other.
 * Seats across an aisle (such as [3,3] and [3,4]) are not considered to be next to each
 * other, however, It is permissible for the four-person family to be separated by an
 * aisle, but in that case, exactly two people have to sit on each side of the aisle.
 *
 * Example 1:
 * Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
 * Output: 4
 * Explanation: The figure above shows the optimal allocation for four families, where
 * seats mark with blue are already reserved and contiguous seats mark with orange are for
 * one family.
 *
 * Example 2:
 * Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
 * Output: 2
 *
 * Example 3:
 * Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
 * Output: 4
 *
 * Constraints:
 * 1 <= n <= 10^9
 * 1 <= reservedSeats.length <= min(10*n, 10^4)
 * reservedSeats[i].length == 2
 * 1 <= reservedSeats[i][0] <= n
 * 1 <= reservedSeats[i][1] <= 10
 * All reservedSeats[i] are distinct.
 */
public class Solution {
    // tc O(m), sc O(m); m = reserved_rows
    // 15 ms, faster than 100.00%; 44.1 MB, less than 100.00%
    // https://leetcode.com/problems/cinema-seat-allocation/discuss/546451/Java-Straightforward-solution-(bitwise)
    // seats 2,3,4,5 can be represented as (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) = 60, for example.
    // So, I use this value to check whether the seats 2,3,4,5 are available when traversing the graph
    // (together with 6,7,8,9 and 4,5,6,7).
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> graph = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            graph.put(row, graph.getOrDefault(row, 0) | (1 << col)); // create a bit vector of reserved seats
        }

        int max = 0;
        for (int reserved : graph.values()) {
            int count = 0;
            if ((reserved & 60) == 0) count = 1; // check if seats 2,3,4,5 are available
            if ((reserved & 960) == 0) count += 1; // check if seats 6,7,8,9 are available
            if (count == 0 && (reserved & 240) == 0) count = 1; // check if seats 4,5,6,7 are available
            max += count;
        }

        return max + 2 * (n - graph.size());
    }

    // Memory limit exceeded
    public int maxNumberOfFamilies1(int n, int[][] reservedSeats) {
        List<Integer>[] graph = buildGraph(n, reservedSeats);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i].isEmpty()) {
                count += 2;
            } else {
                List<Integer> seats = graph[i];
                boolean one = graph[i].contains(2) || graph[i].contains(3);
                boolean two = graph[i].contains(4) || graph[i].contains(5);
                boolean three = graph[i].contains(6) || graph[i].contains(7);
                boolean four = graph[i].contains(8) || graph[i].contains(9);
                if (!one && !two) {
                    count++;
                }
                if (!three && !four) {
                    count++;
                }
                if ((one && four) && !two && !three) {
                    count++;
                }
            }
        }
        return count;
    }

    private List<Integer>[] buildGraph(int n, int[][] reservedSeats) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] seat : reservedSeats) {
            graph[seat[0] - 1].add(seat[1]);
        }
        return graph;
    }
}
