package SwordOffer;


import java.util.ArrayList;

// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class S22_PringtFromtTopToBottom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<Integer> arrayList;
    private ArrayList<TreeNode> queue;

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        arrayList = new ArrayList<>();
        queue = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            arrayList.add(node.val);
        }

        return arrayList;
    }
}