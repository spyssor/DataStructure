package SwordOffer;


import java.util.HashMap;

// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class S4_RebuildBTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        for (int i = 0; i < in.length; i ++){
            map.put(in[i], i);
        }

        return reConstructBinaryTree(pre, 0, pre.length-1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL){
        if (preL > preR){
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);
        Integer inIndexOfRoot = map.get(root.val);
        int leftSize = inIndexOfRoot-inL;
        root.left = reConstructBinaryTree(pre, preL+1, preL+leftSize, inL);
        root.right = reConstructBinaryTree(pre, preL+leftSize+1, preR, inIndexOfRoot+1);
        return root;
    }

    public void preOrder(TreeNode node){
        if (node == null){
            return;
        }

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        S4_RebuildBTree s4 = new S4_RebuildBTree();
        s4.preOrder(s4.reConstructBinaryTree(pre, in));
    }
}
