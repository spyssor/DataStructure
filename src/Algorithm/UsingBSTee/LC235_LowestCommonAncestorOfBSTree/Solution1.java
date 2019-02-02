package Algorithm.UsingBSTee.LC235_LowestCommonAncestorOfBSTree;

/// 235. Lowest Common Ancestor of a Binary Search Tree
/// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
/// 时间复杂度: O(lgn), 其中n为树的节点个数
/// 空间复杂度: O(h), 其中h为树的高度
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

    //根据二分搜索树的特点，我们可以知道，再寻找最近的祖先节点时，只有三种可能
    //1、都比当前节点小，那就去左子树继续找。
    //2、都比当前节点大，那就去右子树继续找。
    //3、当前节点就是最近的祖先节点，因为树的特点是每个节点只有一个父辈节点，若一个小于该节点，另一个大于该节点
    //   无论p、q是在左子树或右子树的任何位置，该节点都是最后的那个公共交叉点。又或是该节点就是p或q，那么这个
    //   结论也是成立的。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if (p == null || q == null){
            throw new IllegalArgumentException("p or q cannot be null");
        }

        if (root == null){
            return null;
        }

        if (p.value > root.value && q.value > root.value){
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.value < root.value && q.value < root.value){
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
}
