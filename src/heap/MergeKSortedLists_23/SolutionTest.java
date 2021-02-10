package heap.MergeKSortedLists_23;

import linkedList.utils.ListNode;
import org.junit.jupiter.api.Test;

import static linkedList.utils.Parser.stringToListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(stringToListNode("[1,1,2,3,4,4,5,6]"), s.mergeKLists(new ListNode[] {
                stringToListNode("[1,4,5]"),
                stringToListNode("[1,3,4]"),
                stringToListNode("[2,6]"),
        }));
    }
}
