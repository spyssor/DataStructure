package Algorithm.UsingBSTee.LC257_BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

/// 257. Binary Tree Paths
/// https://leetcode.com/problems/binary-tree-paths/description/
/// 时间复杂度: O(n), n为树中的节点个数
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

    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        if (root.left == null && root.right == null){
            res.add(root.value+"");
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for (String s : leftPaths){
            StringBuilder sb = new StringBuilder(root.value+"");
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for (String s : rightPaths){
            StringBuilder sb = new StringBuilder(root.value+"");
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }

        return res;
    }
}
