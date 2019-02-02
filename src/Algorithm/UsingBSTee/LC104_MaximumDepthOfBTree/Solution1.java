package Algorithm.UsingBSTee.LC104_MaximumDepthOfBTree;

// 104. Maximum Depth of Binary Tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
// 时间复杂度: O(n), n是树中的节点个数
// 空间复杂度: O(h), h是树的高度
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

    public int maxDepth(TreeNode root){

        if (root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int minDepth(TreeNode root){

        if (root.left == null && root.right == null){
            return 1;
        }

        if (root.left !=null && root.right == null){
            return minDepth(root.left) + 1;
        }else if (root.left == null && root.right !=null){
            return minDepth((root.right)) + 1;
        }else{
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
