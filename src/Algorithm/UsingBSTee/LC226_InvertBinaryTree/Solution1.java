package Algorithm.UsingBSTee.LC226_InvertBinaryTree;

/// 226. Invert Binary Tree
/// https://leetcode.com/problems/invert-binary-tree/description/
/// 时间复杂度: O(n), n为树中节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution1 {

    public class TreeNode{

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null){
            return null;
        }

        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);

        root.left = left;
        root.right = right;

        return root;
    }
}
