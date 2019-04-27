package SwordOffer;

import java.util.Stack;

// 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
public class S5_QueueBy2Stack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        S5_QueueBy2Stack queue = new S5_QueueBy2Stack();
        for (int i = 1; i < 6; i ++){
            queue.push(i);
        }
        for (int i = 1; i < 6; i ++){
            System.out.println(queue.pop());
        }
    }
}
