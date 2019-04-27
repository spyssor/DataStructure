package SwordOffer;


// 输入一个链表，输出该链表中倒数第k个结点。
public class S14_FindKthToTail {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    private ListNode res;
    private int count;

    public ListNode FindKthToTail(ListNode head,int k) {
        count = 0;
        find(head, k);
        return res;
    }

    private void find(ListNode head, int k){
        if (head == null){
            return;
        }

        FindKthToTail(head.next, k);
        count ++;
        if (count == k){
             res = head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        for (int i = 1; i < 5; i ++){
            head.next = new ListNode(i+1);
        }
        System.out.println(new S14_FindKthToTail().FindKthToTail(head, 1).val);
    }
}
