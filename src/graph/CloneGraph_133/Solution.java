package graph.CloneGraph_133;

import java.util.*;

import graph.utils.Node;

/**
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 *
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * Example:
 * 1 –– 2
 * |    |
 * 4 –– 3
 *
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},
 * {"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 *
 *
 * Note:
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.
 */
public class Solution {
    private Map<Integer, Node> map = new HashMap<>();

    // DFS, tc O(V + E), sc O(V + E)
    // https://leetcode.com/problems/clone-graph/discuss/42309/Depth-First-Simple-Java-Solution
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node(node.val);
        map.put(node.val, clone);
        clone.neighbors = new ArrayList<>();
        for (Node nbr : node.neighbors) {
            clone.neighbors.add(cloneGraph(nbr));
        }

        return clone;
    }

    /*
                   3            1------2
                  / \           |      |
                 /   \          |      |
                2-----1         4------3
     */
    // BFS, tc O(V + E), sc O(V + E)
    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.put(node.val, new Node(node.val, new ArrayList<>()));
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
                    q.add(neighbor);
                }
                visited.get(n.val).neighbors.add(visited.get(neighbor.val));
            }
        }
        return visited.get(node.val);
    }
}
