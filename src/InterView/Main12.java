package InterView;

import java.util.Scanner;

public class Main12 {

    private static int[] memo;

    public static int climbStairs(int target) {

        if (target < 0){
            return 0;
        }

        memo = new int[target+1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= target; i ++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[target];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int step = sc.nextInt();
        System.out.println(climbStairs(step));
    }

}


