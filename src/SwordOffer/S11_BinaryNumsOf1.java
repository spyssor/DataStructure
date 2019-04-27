package SwordOffer;


// 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
public class S11_BinaryNumsOf1 {

    //1100 -> -1 -> 1011
    //1100 & 1011 -> 1000
    //这样计算了一个1后消除一个1
    public int NumberOf1(int n) {
        int count = 0;

        while (n != 0){
            count ++;

            n = n & (n-1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new S11_BinaryNumsOf1().NumberOf1(4));
    }
}
