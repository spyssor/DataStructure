package Algorithm.DynamicProgramming.LC198_HouseRobber;

import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution2 {

    private int[] memo;

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0){
            return 0;
        }

        memo = new int[n];
        Arrays.fill(memo, -1);
        memo[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i --){
            for (int j = i; j < n;j ++){
                memo[i] = Math.max(memo[i] ,nums[j] + (j+2 >= n ? 0 : memo[j+2]));
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {

        int nums[] = {2, 1, 4, 5, 6};
        System.out.println((new Solution2()).rob(nums));
    }
}
