package Algorithm.UsingLinkedList.LC208_ReverseLinkedList;

// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
//
// 递归的方式反转链表
// 时间复杂度: O(n)
// 空间复杂度: O(n) - 注意，递归是占用空间的，占用空间的大小和递归深度成正比：）
public class Solution2 {

//    // Definition for singly-linked list.
//    private class ListNode{
//        int val;
//        ListNode next;
//        public ListNode(int val){
//            this.val = val;
//        }
//    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head2 = (new Solution2()).reverseList(head);
        System.out.println(head2);
    }
}
