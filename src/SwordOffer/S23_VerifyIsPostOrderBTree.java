package SwordOffer;

// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class S23_VerifyIsPostOrderBTree {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence ==null || sequence.length == 0){
            return false;
        }
        int n = sequence.length-1;

        return isPostOrder(sequence, 0, n);
    }

    private boolean isPostOrder(int[] sequence, int l, int root){
        if (l >= root){
            return true;
        }

        int index = l;
        while (sequence[index] < sequence[root]){
            ++ index;
        }

        for (int i = index; i < root; i ++){
            if (sequence[i] < sequence[root]){
                return false;
            }
        }

        return isPostOrder(sequence, l, index-1)
                && isPostOrder(sequence, index, root-1);
    }

    public static void main(String[] args) {
        S23_VerifyIsPostOrderBTree check = new S23_VerifyIsPostOrderBTree();
        int[] sequence = {5,4,3,2,1};
        boolean b = check.VerifySquenceOfBST(sequence);
        System.out.println(b);
    }
}
