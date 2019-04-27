package SwordOffer;

// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class S13_ReOrderArray {

    public void reOrderArray(int [] array) {
        if (array.length == 0){
            return;
        }

        int n = array.length;
        for (int i = 1; i < n; i ++){
            if (array[i-1] % 2 == 0 && array[i] % 2 == 1){
                int e = array[i];
                for (int j = i; j >= 0; j --){
                    array[j] = array[j-1];
                    if (j-1 == 0 || array[j-2] % 2 == 1){
                        array[j-1] = e;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        new S13_ReOrderArray().reOrderArray(array);
        for (int i = 0; i < array.length; i ++){
            System.out.print(array[i]);
        }
    }
}
