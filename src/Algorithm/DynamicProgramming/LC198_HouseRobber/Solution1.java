package Algorithm.DynamicProgramming.LC198_HouseRobber;

import java.util.Arrays;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution1 {

    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index){

        if (index >= nums.length){
            return 0;
        }

        if (memo[index] != -1){
            return memo[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i ++){
            res = Math.max(res, nums[index] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {

        int nums[] = {2, 1, 4, 5, 6};
        System.out.println((new Solution1()).rob(nums));
    }
}
