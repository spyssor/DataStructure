package Algorithm.DynamicProgramming.LC343_IntegerBreak;

import java.util.Arrays;

/// 343. Integer Break
/// https://leetcode.com/problems/integer-break/description/
/// 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution1 {

    private int[] memo;

    public int integerBreak(int n) {

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return breakInteger(n);
    }

    private int breakInteger(int n){
        if (n == 1){
            return 1;
        }

        if (memo[n] != -1){
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i < n; i ++){
            res = max3(res, i*(n-i), i*breakInteger(n-i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c){

        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).integerBreak(2));
        System.out.println((new Solution1()).integerBreak(10));
    }
}
