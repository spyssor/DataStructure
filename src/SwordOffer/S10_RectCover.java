package SwordOffer;


// 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
public class S10_RectCover {

    private int[] memo;

    public int RectCover(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        memo = new int[target+1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= target; i ++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[target];
    }

    public static void main(String[] args) {
        System.out.println(new S10_RectCover().RectCover(1));
    }
}
