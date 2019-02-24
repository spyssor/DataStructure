package Algorithm.UsingSetMap.LC220_ContainsDuplicateIII;

import java.util.TreeSet;

// 219. Contains Duplicate II
// https://leetcode.com/problems/contains-duplicate-ii/description/
// 时间复杂度: O(n)
// 空间复杂度: O(k)
public class Solution1 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++){
            if (record.ceiling((long) (nums[i] - t)) != null && record.ceiling((long) (nums[i] - t)) <= nums[i] + t){
                return true;
            }
            record.add((long) nums[i]);
            if (record.size() == k+1){
                record.remove(Long.parseLong(nums[i-k]+""));
            }
        }
        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {-48, -47};
        int k = 3;
        int t = 3;
        printBool((new Solution1()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}
