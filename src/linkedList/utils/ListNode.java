package linkedList.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.format("%d->%s", val, next != null ? next : "null");
    }
}
