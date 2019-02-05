package Algorithm.DynamicProgramming.LC70_ClimbingStairs;

import java.util.Arrays;

public class Solution1 {

    private int[] memo;

    public int climbStairs(int n) {

        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    private int calcWays(int n){

        //终结条件：如果还有一节台阶就只有一步，若是还有2节台阶，继续递归最终若是一步一步走就是2步，若是走两步，最后就跑到0这个条件里返回一步。
        if (n == 1 || n == 0){
            return 1;
        }

        if (memo[n] == -1){
            memo[n] = calcWays(n-1) + calcWays(n-2);
        }

        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).climbStairs(10));
    }
}
