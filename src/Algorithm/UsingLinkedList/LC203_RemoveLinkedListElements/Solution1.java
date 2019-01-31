package Algorithm.UsingLinkedList.LC203_RemoveLinkedListElements;

import Algorithm.UsingLinkedList.LC208_ReverseLinkedList.ListNode;

// 203. Remove Linked List Elements
// https://leetcode.com/problems/remove-linked-list-elements/description/
// 不使用虚拟头结点
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {

        // 需要对头结点进行特殊处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next !=null){
            if (cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            }else{
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] arr = {6, 1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution1()).removeElements(head, val);
        System.out.println(head);
    }
}
