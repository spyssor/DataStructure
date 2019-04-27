package SwordOffer;

import java.util.ArrayList;
import java.util.Stack;

// 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
public class S3_PrintLinkFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.empty()){
            arrayList.add(stack.pop());
        }

        return arrayList;
    }
}
