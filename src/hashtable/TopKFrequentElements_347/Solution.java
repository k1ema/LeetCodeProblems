package hashtable.TopKFrequentElements_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {
    // tc O(n), sc O(n)
    // Bucket sort
    // https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
    // 22 ms, faster than 19.28%; 47.7 MB, less than 8.90%
    /*
        1. compute map of frequencies - O(n)
        2. bucket sort:
            init array of lists. index = freq - O(n)
            iterate through this array from last index for k indexes and fill result array
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int ind = e.getValue();
            if (bucket[ind] == null) {
                bucket[ind] = new ArrayList<>();
            }
            bucket[ind].add(e.getKey());
        }
        int[] res = new int[k];
        for (int i = bucket.length - 1, j = 0; i >=0 && j < k; i--) {
            if (bucket[i] == null) continue;
            for (int n : bucket[i]) {
                res[j++] = n;
            }
        }
        return res;
    }

    /*
        1. compare k to n. if k == n -> return nums;
        2. count frequencies of elements. put them to hashmap - O(n)
        3. iterate through map and put pairs to min heap.
            for each step check heap size <= k. if size > k - poll from heap
            O(nlogk)
        4. convert min heap to int[]
    */

    // tc O(nlogk) if k < n and O(n) if k == n, sc O(n)
    // 10 ms, faster than 76.55%; 42.3 MB, less than 37.02%
    int[] topKFrequent1(int[] nums, int k) {
        int n = nums.length;
        if (k == n) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[pq.size()];
        int i = k;
        while (!pq.isEmpty()) {
            res[--i] = pq.poll().getKey();
        }

        return res;
    }

    // Quick select
    // tc O(n), sc O(n)
    // 10 ms, faster than 76.55%; 42.3 MB, less than 38.53%
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int[] freq = new int[nums.length];
        int i = 0;
        for (int f : map.values()) {
            freq[i++] = f;
        }

        int kth = findKthElement(freq, k);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= kth) res.add(entry.getKey());
        }
        return res.stream().mapToInt(j -> j).toArray();
    }

    private int findKthElement(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int l = 0, r = n - 1;
        while (l < r) {
            int j = partition(nums, l, r);
            if (j == k) break;
            if (j < k) l = j + 1;
            else r = j - 1;
        }
        return nums[k];
    }

    private Random rnd = new Random();
    private int partition(int[] nums, int lo, int hi) {
        int pInd = lo + rnd.nextInt(hi - lo + 1);
        int pivot = nums[pInd];
        swap(nums, lo, pInd);

        int i = lo, j = hi;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
