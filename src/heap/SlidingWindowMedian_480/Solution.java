package heap.SlidingWindowMedian_480;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * 480. Sliding Window Median
 * https://leetcode.com/problems/sliding-window-median/
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * Examples:
 * [2,3,4] , the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
 * very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Your job is to output the median array for each window in the original array.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 *
 * Note:
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 * Answers within 10^-5 of the actual value will be accepted as correct.
 */
public class Solution {
    // tc O(nlogk), sc O(n)
    // https://leetcode.com/problems/sliding-window-median/discuss/96346/Java-using-two-Tree-Sets-O(n-logk)
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        Supplier<Double> median = (k % 2 == 0) ?
                () -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
                () -> (double) nums[right.first()];

        // balance lefts size and rights size (if not equal then right will be larger by one)
        Runnable balance = () -> { while (left.size() > right.size()) right.add(left.pollFirst()); };

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) left.add(i);
        balance.run();
        result[0] = median.get();

        for (int i = k, r = 1; i < nums.length; i++, r++) {
            // remove tail of window from either left or right
            if(!left.remove(i - k)) right.remove(i - k);

            // add next num, this will always increase left size
            right.add(i); left.add(right.pollFirst());

            // rebalance left and right, then get median from them
            balance.run(); result[r] = median.get();
        }

        return result;
    }

    // tc O(n * (k + logk)) = O(nk), remove from pq costs O(k)
    // to reduce tc to O(nlogk) we should implement custom heap with the ability of removing object by its index in O(logk) time.
    public double[] medianSlidingWindow1(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        boolean even = k % 2 == 0;
        Queue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> large = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            large.add(nums[i]);
            small.add(large.poll());

            if (small.size() + large.size() > k) {
                int toRemove = nums[i - k];
                if (small.peek() >= toRemove) {
                    small.remove(toRemove);
                } else {
                    large.remove(toRemove);
                }
            }

            if (small.size() > large.size()) {
                large.add(small.poll());
            }

            if (i >= k - 1) {
                res[i - k + 1] = even ? small.peek() / 2d + large.peek() / 2d : large.peek();
            }
        }
        return res;
    }
}
