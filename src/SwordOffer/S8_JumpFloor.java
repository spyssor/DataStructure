package SwordOffer;


//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
public class S8_JumpFloor {

    private int[] memo;

    public int JumpFloor(int target) {

        memo = new int[target+1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= target; i ++){
           memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[target];
    }

    public static void main(String[] args) {
        System.out.println(new S8_JumpFloor().JumpFloor(10));
    }
}
