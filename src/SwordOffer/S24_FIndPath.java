package SwordOffer;


import java.util.ArrayList;

// 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
public class S24_FIndPath {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        res = new ArrayList<>();

        if (target == 0){
            return res;
        }

        ArrayList<Integer> p  = new ArrayList<>();

        findPath(root, target, p);

        return res;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> p){

        p.add(root.val);

        if (root.left == null && root.right == null){
            if (target == root.val){
                res.add((ArrayList<Integer>) p.clone());
                p.remove(p.size()-1);
                return;
            }
        }

        if (root.left != null){
            findPath(root.left, target-root.val, p);
        }
        if (root.right != null){
            findPath(root.right, target-root.val, p);
        }
        p.remove(p.size()-1);
        return;
    }
}
