package Algorithm.UsingArray.LC209_MinimumSizeSubarraySum;

// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
//
// 滑动窗口的思路
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution3 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        while(l < nums.length){
            if (sum < s && r+1 < nums.length){
                sum += nums[++r];
            }else{
                sum -= nums[l++];
            }

            if (sum >= s){
                res = Math.min(res, r-l+1);
            }
        }

        if (res == nums.length + 1){
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution3()).minSubArrayLen(s, nums));
    }
}
