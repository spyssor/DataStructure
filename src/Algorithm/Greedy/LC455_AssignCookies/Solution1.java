package Algorithm.Greedy.LC455_AssignCookies;

import java.util.Arrays;

public class Solution1 {

    /// 455. Assign Cookies
    /// https://leetcode.com/problems/assign-cookies/description/
    /// 先尝试满足最贪心的小朋友
    /// 时间复杂度: O(nlogn)
    /// 空间复杂度: O(1)
    public int findContentChildren1(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1, si = s.length - 1;
        int res = 0;
        while(gi >= 0 && si >= 0){
            if (s[si] >= g[gi]){
                res ++;
                si --;
            }
            gi --;
        }
        return res;
    }

    /// 455. Assign Cookies
    /// https://leetcode.com/problems/assign-cookies/description/
    /// 先尝试满足最不贪心的小朋友
    /// 时间复杂度: O(nlogn)
    /// 空间复杂度: O(1)
    public int findContentChildren2(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, si = 0;
        int res = 0;
        while(gi < g.length && si < s.length){
            if (s[si] >= g[gi]){
                res ++;
                gi ++;
            }
            si ++;
        }
        return res;
    }

    public static void main(String[] args) {

        int g1[] = {1, 2, 3};
        int s1[] = {1, 1};
        System.out.println((new Solution1()).findContentChildren1(g1, s1));
        System.out.println((new Solution1()).findContentChildren2(g1, s1));

        int g2[] = {1, 2};
        int s2[] = {1, 2, 3};
        System.out.println((new Solution1()).findContentChildren1(g2, s2));
        System.out.println((new Solution1()).findContentChildren2(g2, s2));
    }
}
