package SwordOffer;


import java.util.ArrayList;

// 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
public class S20_MinStack {

    private ArrayList<Integer> dataList = new ArrayList<>();
    private ArrayList<Integer> minList = new ArrayList<>();
    private int minValue = Integer.MAX_VALUE;

    public void push(int node) {
        dataList.add(node);
        if (node <= minValue){
            minList.add(node);
            minValue = node;
        }
    }

    public void pop() {
        Integer remove = dataList.remove(dataList.size() - 1);
        if (minList.get(minList.size()-1).equals(remove)){
            minList.remove(minList.size()-1);
        }
    }

    public int top() {
        return dataList.get(dataList.size()-1);
    }

    public int min() {
        return minList.get(minList.size()-1);
    }

    public static void main(String[] args) {
        S20_MinStack stack = new S20_MinStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }
}
