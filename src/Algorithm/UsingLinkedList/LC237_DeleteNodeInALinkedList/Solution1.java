package Algorithm.UsingLinkedList.LC237_DeleteNodeInALinkedList;

import Algorithm.UsingLinkedList.LC208_ReverseLinkedList.ListNode;

// 237. Delete Node in a Linked List
// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
// 时间复杂度: O(1)
// 空间复杂度: O(1)
public class Solution1 {

    public void deleteNode(ListNode node) {

        // 注意: 这个方法对尾节点不适用。题目中要求了给定的node不是尾节点
        // 我们检查node.next, 如果为null则抛出异常, 确保了node不是尾节点
        if(node == null || node.next == null)
            throw new IllegalArgumentException("node should be valid and can not be the tail node.");

        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
        delNode.next = null;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node2 = head.findNode(2);
        (new Solution1()).deleteNode(node2);
        System.out.println(head);
    }
}
