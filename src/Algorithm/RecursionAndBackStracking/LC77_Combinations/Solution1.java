package Algorithm.RecursionAndBackStracking.LC77_Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/// 77. Combinations
/// https://leetcode.com/problems/combinations/description/
/// 时间复杂度: O(n^k)
/// 空间复杂度: O(k)
public class Solution1 {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n < 1 || k < 1 || n < k){
            return res;
        }
        LinkedList<Integer> p = new LinkedList<>();
        generateCombinations(n, k, 1, p);

        return res;
    }

    private void generateCombinations(int n, int k, int start, LinkedList<Integer> p){

        if (p.size() == k){
            res.add((List<Integer>) p.clone());
            return;
        }

        //剪枝，因为最后还需要遍历的个数必须要大于等于k个，k-p.size()是总需要-已分配 = 仍需要的个数。
        //总数是n，所以计算循环结束的边界就是 总数量-仍需的数量 + 1 = 可组合的数量边界。
        for (int i = start; i <= n-(k-p.size())+1; i ++){
            p.add(i);
            generateCombinations(n, k, i+1, p);
            p.removeLast();
        }
        return;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Solution1()).combine(4, 2);
        for(List<Integer> list: res)
            printList(list);
    }
}
