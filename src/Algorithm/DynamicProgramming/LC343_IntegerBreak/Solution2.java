package Algorithm.DynamicProgramming.LC343_IntegerBreak;

import java.util.Arrays;

/// 343. Integer Break
/// https://leetcode.com/problems/integer-break/description/
/// 动态规划
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution2 {

    private int[] memo;

    public int integerBreak(int n) {

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        for (int i = 2; i <= n; i ++){
            for (int j = 1; j <= i-1; j ++){
                memo[i] = max3(memo[i],i*(i-j), i*memo[i-j]);
            }
        }

        return memo[n];
    }

    private int max3(int a, int b, int c){

        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).integerBreak(2));
        System.out.println((new Solution2()).integerBreak(10));
    }
}
