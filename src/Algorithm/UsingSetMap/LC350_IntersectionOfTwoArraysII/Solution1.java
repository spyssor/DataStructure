package Algorithm.UsingSetMap.LC350_IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.TreeMap;

// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)
public class Solution1 {

    public int[] intersection(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1){
            if (!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2){
            if (map.containsKey(num) && map.get(num) > 0){
                res.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        int[] ret = new int[res.size()];
        int index = 0;
        for(Integer num: res)
            ret[index++] = num;

        return ret;
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
