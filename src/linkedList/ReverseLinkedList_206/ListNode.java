package linkedList.ReverseLinkedList_206;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.format("%d->%s", val, next != null ? next : "NULL");
    }
}
