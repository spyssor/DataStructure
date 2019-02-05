package Algorithm.DynamicProgramming.knapsack;

import java.util.Arrays;

/// 背包问题
/// 记忆化搜索
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution1 {

    private int[][] memo;

    //w[i]=wi的重量 v[i]=vi的价值 C=背包容量
    public int knapsack01(int[] w, int[] v, int C){

        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        memo = new int[n][C+1];
        int[] initValue = new int[C+1];
        for (int i = 0; i < C+1 ; i ++){
            initValue[i] = -1;
        }
        Arrays.fill(memo, initValue);

        return bestValue(w, v, n-1, C);
    }

    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int capacity){

        if (capacity <= 0 || index < 0){
            return 0;
        }

        if (memo[index][capacity] != -1){
            return memo[index][capacity];
        }

        int res = bestValue(w, v, index - 1, capacity);
        if (capacity >= w[index]){
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, capacity - w[index]));
        }

        memo[index][capacity] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        System.out.println(solution1.knapsack01(w, v, 5));
    }
}
