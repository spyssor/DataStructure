package InterView;

import java.util.Scanner;

public class Main22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i ++){
            v[i] = sc.nextInt();
        }
        int[] w = new int[n];
        for (int i = 0; i < n; i ++){
            w[i] = sc.nextInt();
        }
        int C = sc.nextInt();
        int res = knapsack(w, v, C);
        System.out.println(res);
    }

    //w[i]=每道题花费的时间 v[i]=每道题的得分 C=总的时间
    public static int knapsack(int[] w, int[] v, int C){

        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        int[] memo = new int[C+1];
        for (int j = 0; j <= C; j ++){
            memo[j] = (w[0] <= j) ? v[0] : 0;
        }
        for (int i = 1; i < n; i ++){
            for (int j = C; j >= w[i]; j --){
                memo[j] = Math.max(memo[j], v[i] + memo[j-w[i]]);
            }
        }
        return memo[C];
    }
}
