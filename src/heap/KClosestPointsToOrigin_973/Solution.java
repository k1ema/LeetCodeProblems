package heap.KClosestPointsToOrigin_973;

import javafx.util.Pair;

import java.util.*;

/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * We have a list of points on the plane. Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except
 * for the order that it is in.)
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 * Note:
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class Solution {
    // quickselect, tc O(n) in average
    // 3 ms, faster than 99.41%; 48.4 MB, less than 100.00%
    public int[][] kClosest(int[][] points, int K) {
        int l = 0, r = points.length - 1;
        while (l < r) {
            int m = partition(points, l, r);
            if (m < K) {
                l = m + 1;
            } else if (m > K) {
                r = m - 1;
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private final static Random rnd = new Random();
    private int partition(int[][] points, int l, int r) {
        int pivotInd = l + rnd.nextInt(r - l + 1);
        int[] pivot = points[pivotInd];
        swap(points, l, pivotInd);
        int i = l, j = r;
        while (i < j) {
            while (i <= j && compare(points[i], pivot)) i++;
            while (i <= j && compare(pivot, points[j])) j--;
            if (i < j) {
                swap(points, i, j);
            }
        }
        swap(points, j, l);
        return j;
    }

    private void swap(int[][] a, int i, int j) {
        int[] tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean compare(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] <= b[0] * b[0] + b[1] * b[1];
    }

    // tc O(nlogk), sc O(k)
    // 36 ms; 48.5 MB
    public int[][] kClosest1(int[][] points, int K) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>((p1, p2) -> p2.getKey() - p1.getKey());
        for (int[] point : points) {
            pq.add(new Pair<>(point[0] * point[0] + point[1] * point[1], point));
            if (pq.size() > K) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll().getValue());
        }
        return res.toArray(new int[0][]);
    }
}
