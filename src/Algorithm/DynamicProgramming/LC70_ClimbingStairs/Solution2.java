package Algorithm.DynamicProgramming.LC70_ClimbingStairs;

public class Solution2 {

    private int[] memo;

    public int climbStairs(int n) {

        memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i ++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).climbStairs(10));
    }
}
