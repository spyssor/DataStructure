package Algorithm.UsingSetMap.LC349_IntersectionOfTwoArrays;

import java.util.TreeSet;

// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/description/
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class Solution1 {

    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1){
            set.add(num);
        }

        TreeSet<Integer> res = new TreeSet<>();
        for (int num : nums2){
            if (set.contains(num)){
                res.add(num);
            }
        }

        int[] resultArray = new int[res.size()];
        int index = 0;
        for (int num : res){
            resultArray[index++] = num;
        }

        return resultArray;
    }

    private static void printArr(int[] arr){
        for(int e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution1()).intersection(nums1, nums2);
        printArr(res);
    }
}
