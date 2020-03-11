package array.TaskScheduler_621;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different
 * letters represent different tasks. Tasks could be done without original order. Each task could be done in
 * one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at
 * least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class Solution {
    // tc O(n), sc O(1), n = tasks.length
    // 3 ms, faster than 77.32%; 42.8 MB, less than 5.88%
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] a = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            a[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                pq.add(a[i]);
            }
        }
        int maxN = pq.poll();
        int idles = (maxN - 1) * n;
        while (!pq.isEmpty()) {
            int N = pq.poll();
            if (N < maxN) {
                idles = Math.max(0, idles - N);
            } else {
                idles = Math.max(0, idles - N + 1);
            }
            n--;
        }
        return tasks.length + idles;
    }
}
