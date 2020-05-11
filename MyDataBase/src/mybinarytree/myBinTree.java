package mybinarytree;

import java.util.Stack;

class TreeNode{
    public int val;
    public TreeNode right;
    public TreeNode left;
    public TreeNode(int val){
        this.val = val;
    }
}
public class myBinTree{
    private static TreeNode root = null;  // 引用二叉树的根节点
    private static int index = 0;     // 仅在创建二叉树时使用
    // 为了快速给出一棵二叉树作为验证
    // 按照前序遍历的规则创建二叉树
    public static TreeNode createBinTree(int[] array, int invalid){
        TreeNode newRoot = null;
        if(index < array.length && array[index] != invalid){

            // 创建根节点
            newRoot = new TreeNode(array[index]);

            // 递归创建根节点的左子树
            ++index;
            newRoot.left = createBinTree(array, invalid);

            // 递归创建根节点的右子树
            ++index;
            newRoot.right = createBinTree(array, invalid);
        }

        return newRoot;
    }
    //前序递归遍历
    public static void preOrder(TreeNode root){
        if(root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //前序非递归遍历
    //借用到栈
    public static void preOrder1(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        //栈不为空
        while(!s.empty()){
            TreeNode cur = s.pop();
            System.out.print(cur.val+" ");

            //因为栈是先进后出，所以如果想要先左后右的话就要先保存右子树再保存左子树
            //判断当前节点是否有右子树,如果有右子树则让他入栈
            if(null != cur.right){
                s.push(cur.right);
            }

            //判断当前节点是否有左子树,如果有左子树则让他入栈
            if(null != cur.left){
                s.push(cur.left);
            }
        }
    }
    public static void inOrder(TreeNode root){
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void inOrder1(TreeNode root){
        if(null == root){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;

        //中序遍历先遍历树的左子树
        //所以首先要做的是从root开始找到最左节点，并保存路径上经过的节点
        while(null != cur || !s.empty()){
            while(null != cur){
                s.push(cur);
                cur = cur.left;
            }
            //退出循环说明cur==null，此时栈顶元素就是二叉树最左侧节点
            cur = s.pop();
            System.out.print(cur.val+" ");
            //以cur为根的左子树和根遍历完了，还剩右子树
            cur = cur.right;
        }

    }
    public static void lastOrder(TreeNode root){
        if(root != null) {
            lastOrder(root.left);
            lastOrder(root.right);
            System.out.print(root.val + " ");
        }
    }
    public static void lastOrder1(TreeNode root){
        //还是先判断root是否为空
        if(null == root){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(null != cur || !s.empty()){
            s.push();
        }

    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3,-2, -2, -2, 4, 5, -2, -2, 6};
        TreeNode root = createBinTree(array, -2);

        preOrder(root);
        preOrder1(root);
        System.out.println();

        inOrder(root);
        inOrder1(root);
        System.out.println();
    }
}
