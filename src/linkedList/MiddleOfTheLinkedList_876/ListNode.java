package linkedList.MiddleOfTheLinkedList_876;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (next != null) {
            sb.append(",").append(next);
        }
        return sb.toString();
    }
}
