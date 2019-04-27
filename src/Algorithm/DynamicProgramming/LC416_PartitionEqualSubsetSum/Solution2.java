package Algorithm.DynamicProgramming.LC416_PartitionEqualSubsetSum;

import java.util.Arrays;

/// 416. Partition Equal Subset Sum
/// https://leetcode.com/problems/partition-equal-subset-sum/description/
/// 动态规划
/// 时间复杂度: O(len(nums) * O(sum(nums)))
/// 空间复杂度: O(len(nums) * O(sum(nums)))
public class Solution2 {

    private boolean[] memo;

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i ++){
            sum += nums[i];
        }

        if (sum % 2 != 0){
            return false;
        }

        int n = nums.length;
        int C = sum / 2;

        memo = new boolean[C + 1];
        Arrays.fill(memo, false);

        for (int i = 0; i <= C; i ++){
           memo[i] = (nums[0] == i);
        }
        for (int i = 1; i < n; i ++){
            for (int j = C; j >= nums[i]; j --){
                memo[j] = memo[j] || memo[j-nums[i]];
            }
        }
        return memo[C];
    }

    private static void printBool(boolean res){
        System.out.println(res ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        printBool((new Solution2()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        printBool((new Solution2()).canPartition(nums2));
    }
}
