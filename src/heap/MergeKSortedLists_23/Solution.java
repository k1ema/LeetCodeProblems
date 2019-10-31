package heap.MergeKSortedLists_23;

import linkedList.utils.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class Solution {
    // PriorityQueue solution
    // https://leetcode.com/problems/merge-k-sorted-lists/discuss/10528/A-java-solution-based-on-Priority-Queue
    // tc O(Nlogk), k is the number of linked lists.
    ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(ln -> ln.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    // Solution based on heapsort
    // tc O(NLogN), sc O(N)
    // 5 ms, faster than 76.23%; 43.2 MB, less than 27.33%
    ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        // here we can use just library Quick sort algorithm
//        Collections.sort(list); // 7 ms, faster than 47.24%; 43.3 MB, less than 26.78%

        // Heapsort variant
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        sort(a);

        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        for (int num : a) {
            tmp.next = new ListNode(num);
            tmp = tmp.next;
        }
        return dummy.next;
    }

    private static void sort(int[] a) {
        int N = a.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            sink(a, i, N);
        }
        while (N > 0) {
            exch(a, 0, N);
            sink(a, 0, --N);
        }
    }

    private static void sink(int[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }
}
