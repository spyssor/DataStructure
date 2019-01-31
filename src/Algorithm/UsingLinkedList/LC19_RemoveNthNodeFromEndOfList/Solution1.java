package Algorithm.UsingLinkedList.LC19_RemoveNthNodeFromEndOfList;

import Algorithm.UsingLinkedList.LC208_ReverseLinkedList.ListNode;

import java.util.List;

// 19. Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
//
// 递归到最后一个开始计数为1
// 每次返回到上层函数计数加一
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution1 {

    private int count = 0;

    public ListNode remvoeNthFromEnd(ListNode head, int n){


        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        return remove(dummyHead, n).next;
    }

    private ListNode remove(ListNode head, int n) {
        if (head.next == null){
            count = 1;
            return head;
        }
        ListNode delNode = remove(head.next, n);
        if (count == n){
            head.next = delNode.next;
            delNode.next = null;
        }

        count++;
        return head;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution1()).remvoeNthFromEnd(head, 2);
        System.out.println(head);
    }
}
