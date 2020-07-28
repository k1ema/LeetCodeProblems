package array.TaskScheduler_621;

import java.util.Arrays;
import java.util.Comparator;
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
    public int leastInterval2(char[] tasks, int n) {
        int[] a = new int[26];
        for (char c : tasks) {
            a[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int v : a) {
            pq.add(v);
        }

        int maxN = pq.poll();
        int idles = (maxN - 1) * n;
        while (!pq.isEmpty()) {
            int nextTask = pq.poll();
            if (nextTask == maxN) {
                idles = Math.max(0, idles - nextTask + 1);
            } else {
                idles = Math.max(0, idles - nextTask);
            }
        }

        return tasks.length + idles;
    }

    // same approach but w/o heap
    // tc O(n), sc O(1), n = tasks.length
    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
        int[] frequencies = new int[26];
        for (int t : tasks) {
            frequencies[t - 'A']++;
        }

        Arrays.sort(frequencies);

        // max frequency
        int f_max = frequencies[25];
        int idle_time = (f_max - 1) * n;

        for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; --i) {
            idle_time -= Math.min(f_max - 1, frequencies[i]);
        }
        idle_time = Math.max(0, idle_time);

        return idle_time + tasks.length;
    }
}
