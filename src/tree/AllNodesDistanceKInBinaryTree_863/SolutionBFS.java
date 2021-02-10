package tree.AllNodesDistanceKInBinaryTree_863;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
public class SolutionBFS implements Solution {
    // tc O(n), sc O(n)
    // BFS + map child - parent
    // 10 ms, faster than 83.94%; 39.4 MB, less than 5.26%
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143752/JAVA-Graph-%2B-BFS
    Map<TreeNode, TreeNode> childParent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null || K < 0) return res;

        childParent = new HashMap<>();
        buildMap(root, null);
        if (!childParent.containsKey(target)) return res;

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size; i++) {
                    res.add(q.poll().val);
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                visited.add(node);
                if (node.left != null && !visited.contains(node.left)) q.add(node.left);
                if (node.right != null && !visited.contains(node.right)) q.add(node.right);
                TreeNode parentNode = childParent.get(node);
                if (parentNode != null && !visited.contains(parentNode)) q.add(parentNode);
            }
            K--;
        }

        return res;
    }

    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        childParent.put(node, parent);
        buildMap(node.left, node);
        buildMap(node.right, node);
    }

    // same approach but different map structure
    Map<TreeNode, List<TreeNode>> map;
    public List<Integer> distanceK1(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null || K < 0) return res;

        map = new HashMap<>();
        buildMap1(root, null);
        if (!map.containsKey(target)) return res;

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size; i++) {
                    res.add(q.poll().val);
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }

        return res;
    }

    private void buildMap1(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            buildMap1(node.left, node);
            buildMap1(node.right, node);
        }
    }
}
