package tree.AllNodesDistanceKInBinaryTree_863;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 863. All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.
 * The answer can be returned in any order.
 *
 * Example 1:
 *                       3
 *                    /    \
 *                   5      1
 *                  / \    / \
 *                 6   2  0   8
 *                    / \
 *                   7   4
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 *
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 *
 * Note:
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 */
public class SolutionDFS implements Solution {
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143798/1ms-beat-100-simple-Java-dfs-with(without)-hashmap-including-explanation
    /*
        1. start finding target node in a root tree recursively
        2. if the target is found, track the distance from target to current node in a map while getting upwards back
        3. run dfs in root tree and store all nodes which length equals to K
    */
    private Map<TreeNode, Integer> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        map = new HashMap<>();
        find(root, target);
        List<Integer> res = new ArrayList<>();
        dfs(root, K, map.get(root), res);
        return res;
    }

    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root.equals(target)) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, K, length + 1, res);
        dfs(root.right, K, length + 1, res);
    }


    // my solution
    public List<Integer> distanceK1(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        dfs(root, target, K, null, res);
        return res;
    }

    private int dfs(TreeNode root, TreeNode target, int k, Integer dist, List<Integer> list) {
        if (root == null) return 0;
        Integer nextDist = null;
        if (dist != null || root.equals(target)) {
            nextDist = (dist == null ? 0 : dist) + 1;
        }
        int left = dfs(root.left, target, k, nextDist, list);
        if (left > 0) {
            nextDist = left + 1;
        }
        int right = dfs(root.right, target, k, nextDist, list);
        if (dist != null && dist == k || k == 0 && root.equals(target) || left > 0 && left == k || right > 0 && right == k) {
            list.add(root.val);
        }
        if (right > 0 && left == 0) {
            nextDist = right + 1;
            dfs(root.left, target, k, nextDist, list);
        }
        int res = 0;
        if (root.equals(target)) {
            res = 1;
        } else if (left > 0) {
            res = left + 1;
        } else if (right > 0) {
            res = right + 1;
        }
        return res;
    }
}
