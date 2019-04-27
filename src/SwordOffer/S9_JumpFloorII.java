package SwordOffer;

import java.util.Arrays;

public class S9_JumpFloorII {
    private int[] memo;
    public int JumpFloorII(int target) {
        memo = new int[target+1];
        Arrays.fill(memo, -1);

        return calcJump(target);
    }

    private int calcJump(int target){
        if (target == 0){
            return 1;
        }
        if (target == 1){
            return 1;
        }

        if (memo[target] != -1){
            return memo[target];
        }

        memo[target] = 0;
        for (int i = target; i >= 1; i --){
            memo[target] += calcJump(target-i);
        }

        return memo[target];
    }

    public static void main(String[] args) {
        System.out.println(new S9_JumpFloorII().JumpFloorII(5));
    }
}
