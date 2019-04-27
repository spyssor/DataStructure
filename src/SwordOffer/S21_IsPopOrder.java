package SwordOffer;


import java.util.Stack;

// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
public class S21_IsPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int len = pushA.length;
        for (int i = 0, j = 0; i < len; i ++){
            stack.push(pushA[i]);
            while (j < len && stack.peek() == popA[j]){
                stack.pop();
                j ++;
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        S21_IsPopOrder isPopOrder = new S21_IsPopOrder();
        int[] pushA = {1,2,3,4,5};
        int[] popA1 = {4,5,3,2,1};
        int[] popA2 = {4,5,3,1,2};
        boolean one = isPopOrder.IsPopOrder(pushA, popA1);
        boolean two = isPopOrder.IsPopOrder(pushA, popA2);
        System.out.println(one);
        System.out.println(two);
    }
}
