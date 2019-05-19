package linkedList.MiddleOfTheLinkedList_876;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode middle = s.middleNode1(node);
        System.out.println(middle); // 3

        node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        middle = s.middleNode1(node);
        System.out.println(middle); // 4

        node = new ListNode(1);
        middle = s.middleNode1(node);
        System.out.println(middle); // 1

        node = new ListNode(1);
        node.next = new ListNode(2);
        middle = s.middleNode1(node);
        System.out.println(middle); // 2
    }
}
