package tree.SerializeAndDeserializeN_aryTree_428;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();

        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n3 = new Node(3, Arrays.asList(n5, n6));

        Node n2 = new Node(2);
        Node n4 = new Node(4);

        Node n1 = new Node(1, Arrays.asList(n3, n2, n4));

        Node actual = s.deserialize(s.serialize(n1));
        assertEquals(n1, actual);
    }
}