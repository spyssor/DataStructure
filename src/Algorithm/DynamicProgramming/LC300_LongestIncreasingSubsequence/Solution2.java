package Algorithm.DynamicProgramming.LC300_LongestIncreasingSubsequence;


import java.util.Arrays;

/// 300. Longest Increasing Subsequence
/// https://leetcode.com/problems/longest-increasing-subsequence/description/
/// 动态规划
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class Solution2 {

    private int[] memo;

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, 1);
        int res = memo[0];
        for (int i = 1; i < n; i ++){
            for (int j = 0; j < i; j ++){
                if (nums[i] > nums[j]){
                    memo[i] = Math.max(memo[i], 1+memo[j]);
                }
            }
            res = Math.max(res, memo[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        int nums1[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println((new Solution2()).lengthOfLIS(nums1));
        // 4

        // ---

        int nums2[] = {4, 10, 4, 3, 8, 9};
        System.out.println((new Solution2()).lengthOfLIS(nums2));
        // 3

        // ---

        int nums3[] = {2, 2};
        System.out.println((new Solution2()).lengthOfLIS(nums3));
        // 1

        // ---

        int nums4[] = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new Solution2()).lengthOfLIS(nums4));
        // 6
    }
}
