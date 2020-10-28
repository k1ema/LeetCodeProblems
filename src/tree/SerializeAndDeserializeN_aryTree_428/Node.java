package tree.SerializeAndDeserializeN_aryTree_428;

import java.util.List;
import java.util.Objects;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return val == node.val && Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, children);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (children != null && !children.isEmpty()) {
            sb.append(":[");
            for (int i = 0; i < children.size(); i++) {
                sb.append(children.get(i));
                if (i < children.size() - 1) sb.append(",");
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
