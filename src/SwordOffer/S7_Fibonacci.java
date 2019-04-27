package SwordOffer;


// 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
// n<=39
public class S7_Fibonacci {

    private int[] memo;

    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i ++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new S7_Fibonacci().Fibonacci(5));//8
    }
}
