package Algorithm.DynamicProgramming.LC416_PartitionEqualSubsetSum;

import java.util.Arrays;

/// 416. Partition Equal Subset Sum
/// https://leetcode.com/problems/partition-equal-subset-sum/description/
/// 记忆化搜索
/// 时间复杂度: O(len(nums) * O(sum(nums)))
/// 空间复杂度: O(len(nums) * O(sum(nums)))
public class Solution1 {

    private int[][] memo;

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i ++){
            sum += nums[i];
        }

        if (sum % 2 != 0){
            return false;
        }

        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i ++){
            Arrays.fill(memo[i], -1);
        }
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    private boolean tryPartition(int[] nums, int index, int sum){
        if (sum == 0){
            return true;
        }

        if (index < 0 || sum < 0){
            return false;
        }

        if (memo[index][sum] != -1){
            return memo[index][sum] == 1;
        }

        memo[index][sum] = (tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;

        return memo[index][sum] == 1;
    }

    private static void printBool(boolean res){
        System.out.println(res ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        printBool((new Solution1()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        printBool((new Solution1()).canPartition(nums2));
    }
}
