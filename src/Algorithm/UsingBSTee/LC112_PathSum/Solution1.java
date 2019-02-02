package Algorithm.UsingBSTee.LC112_PathSum;

/// 112. Path Sum
/// https://leetcode.com/problems/path-sum/description/
/// 时间复杂度: O(n), n为树的节点个数
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

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null){
            return false;
        }

        if (root.left == null && root.right == null){
            return sum == root.value;
        }

        return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value);
    }
}
