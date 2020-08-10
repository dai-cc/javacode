package day4;

import java.util.Scanner;

/*
* 编一个程序，读入用户输入的一串先序遍历字符串，
* 根据此字符串建立一个二叉树（以指针方式存储）。
* 例如如下的先序遍历字符串： ABC##DE#G##F###
* 其中“#”表示的是空格，空格字符代表空树。
* 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
* */
class TreeNode{
    TreeNode left = null;
    TreeNode right = null;

    char val = 0;
    public TreeNode(char val) {
        this.val = val;
    }
}
class BinTree {
    private TreeNode root = null;
    int i = 0;
    // 前序遍历的字符串s和s中代表空树的字符invalid
    BinTree(String s, char invalid) {
        root = createBT(s, invalid);
    }

    // 递归创建二叉树
    public TreeNode createBT(String s, char invalid) {
        //int i = 0; 不能放在这里
        TreeNode newRoot = null;
        if (i < s.length() && s.charAt(i) != invalid) {
            newRoot = new TreeNode(s.charAt(i));
            i++;
            newRoot.left = createBT(s, invalid);

            i++;
            newRoot.right = createBT(s, invalid);
        }
        return newRoot;
    }

    // 中序遍历
    public void inOrder(){
        // root在BTtree里面才有，所以外部调用的时候无法传参，所以加一个无参的方法
        inOrder(root);
        System.out.println();
    }
    public void inOrder(TreeNode root){
        if(null == root){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}

public class CreateBT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            BinTree bt = new BinTree(s,'#');
            bt.inOrder();
        }
    }
}
