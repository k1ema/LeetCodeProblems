package greedy.PartitionLabels_763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/
 *
 * A string S of lowercase English letters is given. We want to partition this string into as many parts
 * as possible so that each letter appears in at most one part, and return a list of integers representing
 * the size of these parts.
 *
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 */
public class Solution {
    // tc O(n), sc O(1)
    /*
            0 1 2 3 4 5 6 7 8 9 10 11
            a b c a b c d e f d e f
     */
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

    // tc O(n), sc O(1)
    // my solution, using merge intervals
    public List<Integer> partitionLabels1(String S) {
        List<Integer> res = new ArrayList<>();
        int n = S.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            first[S.charAt(i) - 'a'] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            if (first[i] == -1) continue;
            intervals.add(new int[] {first[i], last[i]});
        }

        // merge intervals
        List<int[]> merged = new ArrayList<>();
        intervals.sort((a, b) -> a[0] - b[0]);
        int[] newInterval = intervals.get(0);
        for (int[] interval : intervals) {
            if (interval[0] > newInterval[1]) {
                merged.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        merged.add(newInterval);

        for (int[] interval : merged) {
            res.add(interval[1] - interval[0] + 1);
        }

        return res;
    }
}
