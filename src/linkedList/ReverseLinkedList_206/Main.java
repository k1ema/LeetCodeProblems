package linkedList.ReverseLinkedList_206;

public class Main {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(node);
        ListNode reverse = s.reverseList2(node);
        System.out.println(reverse);

        s = new Solution();
        node = new ListNode(1);
        System.out.println(node);
        reverse = s.reverseList2(node);
        System.out.println(reverse);

        // leetcode
        System.out.println("-------------");
        s = new Solution();
        node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(node);
        reverse = s.reverseListLeetCode(node);
        System.out.println(reverse);

        s = new Solution();
        node = new ListNode(1);
        System.out.println(node);
        reverse = s.reverseListLeetCode(node);
        System.out.println(reverse);
    }
}
