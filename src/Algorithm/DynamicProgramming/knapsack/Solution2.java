package Algorithm.DynamicProgramming.knapsack;

/// 背包问题
/// 动态规划
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution2 {

    //w[i]=wi的重量 v[i]=vi的价值 C=背包容量
    public int knapsack02(int[] w, int[] v, int C){

        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        int[][] memo = new int[n][C+1];
        for (int j = 0; j <= C; j ++){
                memo[0][j] = (w[0] <= j) ? v[0] : 0;
        }
        for (int i = 1; i < n; i ++){
            for (int j = 0; j <= C; j ++){
                memo[i][j] = memo [i-1][j];
                if (j >= w[i]){
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i-1][j-w[i]]);
                }
            }
        }
        return memo[n-1][C];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        System.out.println(solution2.knapsack02(w, v, 5));
    }
}
