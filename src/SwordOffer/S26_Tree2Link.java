package SwordOffer;


//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class S26_Tree2Link {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode head = null;
    private TreeNode tail = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }

        Convert(pRootOfTree.left);
        if (tail == null){
            head = tail = pRootOfTree;
        }
        else{
            tail.right = pRootOfTree;
            pRootOfTree.left = tail;
            tail = pRootOfTree;
        }

        Convert(pRootOfTree.right);

        return head;
    }
}
