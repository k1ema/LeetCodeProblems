package dfs_bfs.NestedListWeightSum_339;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 339. Nested List Weight Sum
 * https://leetcode.com/problems/nested-list-weight-sum/
 *
 * You are given a nested list of integers nestedList. Each element is either an integer or
 * a list whose elements may also be integers or other lists.
 *
 * The depth of an integer is the number of lists that it is inside of. For example, the nested
 * list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 *
 * Return the sum of each integer in nestedList multiplied by its depth.
 *
 * Example 1:
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1. 1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 10.
 *
 * Example 2:
 * Input: nestedList = [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
 *
 * Example 3:
 * Input: nestedList = [0]
 * Output: 0
 *
 * Constraints:
 * 1 <= nestedList.length <= 50
 * The values of the integers in the nested list is in the range [-100, 100].
 * The maximum depth of any integer is less than or equal to 50.
 */
public class Solution {
    // BFS
    public int depthSum(List<NestedInteger> nestedList) {
        Deque<NestedInteger> queue = new ArrayDeque<>();
        queue.addAll(nestedList);
        int res = 0, depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger ni = queue.poll();
                if (ni.isInteger()) {
                    res += ni.getInteger() * depth;
                } else {
                    queue.addAll(ni.getList());
                }
            }
            depth++;
        }
        return res;
    }

    // DFS
    public int depthSum1(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                res += ni.getInteger() * depth;
            } else {
                res += dfs(ni.getList(), depth + 1);
            }
        }
        return res;
    }

    public int depthSum2(List<NestedInteger> nestedList) {
        Deque<Pair<List<NestedInteger>, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(nestedList, 1));
        int res = 0;
        while (!stack.isEmpty()) {
            Pair<List<NestedInteger>, Integer> pair = stack.poll();
            List<NestedInteger> list = pair.getKey();
            int depth = pair.getValue();
            for (NestedInteger ni : list) {
                if (ni.isInteger()) {
                    res += ni.getInteger() * depth;
                } else {
                    stack.push(new Pair<>(ni.getList(), depth + 1));
                }
            }
        }
        return res;
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
