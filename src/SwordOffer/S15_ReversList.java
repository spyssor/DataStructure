package SwordOffer;

// 输入一个链表，反转链表后，输出新链表的表头。
public class S15_ReversList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode newHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
