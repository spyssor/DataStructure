package Algorithm.UsingSetMap.LC447_NumberOfBoomerangs;

import java.util.HashMap;

// 447. Number of Boomerangs
// https://leetcode.com/problems/number-of-boomerangs/description/
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
public class Solution1 {

    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i ++){
            HashMap<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j ++){
                if (j != i){
                    int dis = dis(points[i], points[j]);
                    if (record.containsKey(dis)){
                        record.put(dis, record.get(dis) + 1);
                    }else{
                        record.put(dis, 1);
                    }
                }
            }
            for (Integer dis : record.keySet()){
//                if (record.get(dis) > 1){
                    res += record.get(dis) * (record.get(dis) - 1);
//                }
            }
        }
        return res;
    }

    private int dis(int[] pa, int[] pb){
        return  (pa[0] - pb[0]) * (pa[0] - pb[0]) +
                (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new Solution1()).numberOfBoomerangs(points));
    }
}
