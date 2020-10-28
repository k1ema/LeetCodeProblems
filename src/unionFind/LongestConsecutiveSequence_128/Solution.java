package unionFind.LongestConsecutiveSequence_128;

import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // value, index
        UnionFind uf = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;
            if (nums[i] != Integer.MAX_VALUE && map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
            if (nums[i] != Integer.MIN_VALUE && map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
            map.put(nums[i], i);
        }
        return uf.maxUnion();
    }

    private static class UnionFind {
        int[] id;
        int[] size;

        UnionFind(int n) {
            id = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }

        void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (p == q) return;
            if (size[p] < size[q]) {
                id[p] = q;
                size[q] += size[p];
            } else {
                id[q] = p;
                size[p] += size[q];
            }
        }

        int find(int i) {
            while (id[i] != i) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        int maxUnion() {
            int[] freq = new int[id.length];
            int max = 0;
            for (int i = 0; i < id.length; i++) {
                int root_i = find(i);
                freq[root_i]++;
                max = Math.max(max, freq[root_i]);
            }
            return max;
        }
    }

    // tc O(n), sc O(n)
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = 1;
                while (set.contains(num + 1)) {
                    num++;
                    current++;
                }
                longest = Math.max(longest, current);
            }
        }

        return longest;
    }

    // tc O(nlogn), sc O(1)
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int len = 1, maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] - nums[i - 1] == 1) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 1;
            }
        }
        return maxLen;
    }
}
