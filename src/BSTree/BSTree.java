package BSTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class BSTree<E extends Comparable<E>> {

    private class Node{

        private E e;
        private Node left, right;

        public Node(E e){

            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTree(){

        root = null;
        size = 0;
    }

    public int getSize(){

        return size;
    }

    public boolean isEmpty(){

        return size == 0;
    }

    public void add(E e){

        root = add(root, e);
    }

    private Node add(Node node, E e) {

        if (node == null){
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e){

        return contains(root, e);
    }

    private boolean contains(Node node, E e){

        if (node == null){
            return false;
        }

        if (e.compareTo(node.e) == 0){
            return true;
        } else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder(){

        preOrder(root);
    }

    private void preOrder(Node node){

        if (node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){

        inOrder(root);
    }

    private void inOrder(Node node){

        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){

        postOrder(root);
    }

    private void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void preOrderNR(){

        Stack<Node> stack = new Stack();
        stack.push(root);
        Node cur;
        while(!stack.isEmpty()){
            cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void levelOrder(){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node cur;
        while(!queue.isEmpty()){
            cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public E minimum(){

        if (size == 0){
            throw new IllegalArgumentException("BSTree is empty");
        }

        return minimum(root).e;
    }

    private Node minimum(Node node){

        if (node.left == null){

            return node;
        }

        return minimum(node.left);
    }

    public E maximum(){

        if (size == 0){
            throw new IllegalArgumentException("BSTree is empty");
        }

        return maximum(root).e;
    }

    private Node maximum(Node node){

        if (node.right == null){

            return node;
        }

        return maximum(node.right);
    }

    public E removeMin(){

        E ret = minimum();
        root = removeMin(root);


        return ret;
    }

    public Node removeMin(Node node){

        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){

        E ret = maximum();
        root = removeMax(root);

        return ret;
    }

    public Node removeMax(Node node){

        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){

        remove(root, e);
    }

    private Node remove(Node node, E e){

        if (node == null){
            return null;
        }

        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        } else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else{
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;

            return successor;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
