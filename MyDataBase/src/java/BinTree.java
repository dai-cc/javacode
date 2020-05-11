package java;
/**
 * @Author: will
 * @Date: 2020/2/25
 * @description:
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;


// 二叉树采用孩子表示法
class BTNode{
    BTNode left = null;  // 指向该节点的左子树
    BTNode right = null; // 指向该节点的右子树
    int val;

    public BTNode(int val){
        this.val = val;
    }
}



//class Number
//{
//    public Number(int first, int second)
//    {
//        this.first = first;
//        this.second = second;
//    }
//
//    int first;
//    int second;
//}

public class BinTree {
    private BTNode root = null;  // 引用二叉树的根节点
    private int index = 0;     // 仅在创建二叉树时使用
    // 为了快速给出一棵二叉树作为验证
    public BinTree(int[] array, int invalid){
        root = createBinTree(array, invalid);
    }


    // 按照前序遍历的规则创建二叉树
    BTNode createBinTree(int[] array, int invalid){
        BTNode newRoot = null;
        if(index < array.length && array[index] != invalid){

            // 创建根节点
            newRoot = new BTNode(array[index]);

            // 递归创建根节点的左子树
            ++index;
            newRoot.left = createBinTree(array, invalid);

            // 递归创建根节点的右子树
            ++index;
            newRoot.right = createBinTree(array, invalid);
        }

        return newRoot;
    }

    public void preOrder()
    {
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println();
    }

    public void preOrderNor1(){
        if(null == root){
            return;
        }

        Stack<BTNode> s = new Stack<>();
        s.push(root);

        while(!s.empty()){
            BTNode cur = s.peek();
            System.out.print(cur.val + " ");
            s.pop();

            // 如果cur存在右子树，将cur的右子树入栈
            if(null != cur.right){
                s.push(cur.right);
            }

            // 如果cur的左子树存在，将cur的左子树入栈
            if(null != cur.left){
                s.push(cur.left);
            }
        }

        System.out.println();
    }

    public void preOrderNor2(){
        if(null == root){
            return;
        }

        Stack<BTNode> s = new Stack<>();
        s.push(root);

        while(!s.empty()){
            BTNode cur = s.peek();
            s.pop();

            while(null != cur){
                // 顺序cur左侧的路径一直往下遍历，并保存所经路径中所有的右子树
                System.out.print(cur.val + " ");

                if(null != cur.right){
                    s.push(cur.right);
                }

                cur = cur.left;
            }
        }

        System.out.println();
    }

    public void inOrder(){
        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println();
    }

    public void inOrderNor(){
        if(null == root){
            return;
        }

        BTNode cur = root;
        Stack<BTNode> s = new Stack<>();

        while(null != cur || !s.empty()) {
            // 1. 找以root为根的二叉树最左侧的节点，并保存所经路径中所有的节点--栈
            while(null != cur){
                s.push(cur);
                cur = cur.left;
            }

            // cur为空，认为该棵树已经遍历
            // 可以遍历cur的根节点，cur的根节点次数在栈顶
            cur = s.peek();
            System.out.print(cur.val + " ");
            s.pop();

            // 以cur为根的二叉树：左子树已经遍历，根节点已经遍历，剩余右子树没有遍历
            cur = cur.right;
        }
    }

    public void postOrder(){
        System.out.print("后序序遍历：");
        postOrder(root);
        System.out.println();
    }

    public void postOrderNor(){
        BTNode cur = root;
        BTNode prev = null;  // 标记刚刚遍历过的节点
        Stack<BTNode> s = new Stack<>();

        while(null != cur || !s.empty()) {
            // 1. 找以cur为根的二叉树最左侧的节点，并保存所经路径中的所有节点
            while(null != cur){
                s.push(cur);
                cur = cur.left;
            }

            // 2. 获取cur的子树的根
            BTNode top = s.peek();

            // 3. 遍历top的右子树
            // top的右子树为空--->就可以遍历根节点
            // top的右子树已经遍历完成--->就可以遍历根节点
            if(null == top.right || top.right == prev){
                System.out.print(top.val + " ");
                prev = top;
                s.pop();
            }
            else{
                // top的右子树不为空
                cur = top.right;
            }
        }

        System.out.println();
    }

    // 层序遍历
    public void LevelOrder(){
        if(null == root){
            return;
        }

        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BTNode cur = q.poll();
            System.out.print(cur.val);

            // 如果cur有左子树，让左子树入队列
            if(null != cur.left){
                q.offer(cur.left);
            }

            // 如果cur有右子树，让右子树入队列
            if(null != cur.right){
                q.offer(cur.right);
            }
        }

        System.out.println();
    }

    public boolean isCompleteTree(){
        // 空树也是完全二叉树
        if(null == root){
            return true;
        }

        // 树非空
        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);
        boolean isLeafOrLeft = false;
        while(!q.isEmpty()){
            BTNode cur = q.poll();
            if(isLeafOrLeft){
                // 2. 从第一个不饱和节点之后，所有节点不能有孩子节点
                if(null != cur.left || null != cur.right){
                    return false;
                }
            }
            else
            {
                // 1. 按照层序遍历的方式找第一个不饱和节点(叶子，只有一个孩子的节点)
                // cur节点的左右孩子均存在
                if(null != cur.left && null != cur.right){
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                else if(null != cur.left){
                    // cur只有左孩子
                    q.offer(cur.left);
                    isLeafOrLeft = true;
                }
                else if(null != cur.right){
                    // cur只有右孩子
                    return false;
                }
                else {
                    // cur是叶子节点
                    isLeafOrLeft = true;
                }
            }
        }

        return true;
    }

    public int getNodeCount(){
        return getNodeCount(root);
    }

    //获取叶子节点个数
    public int getLeafNodeCount(){
        return getLeafNodeCount(root);
    }

    // 获取第K层中节点的个数
    public int getKLevelNodeCount(int k){
        return getKLevelNodeCount(root, k);
    }

    // 求二叉树的高度
    public int getHeight()
    {
        return getHeight(root);
    }

    // 获取val在树中对应的节点，找到返回节点，否则返回null
    public BTNode find(int val)
    {
        return find(root, val);
    }

    // 假设: 遍历操作--->将节点中的值域打印出来
    // 前序遍历: 根节点---->根节点的左子树--->根节点的右子树
    private void preOrder(BTNode root){
        if(null != root){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    // 中序遍历：根的左子树--->根节点--->根的右子树
    private void inOrder(BTNode root){
        if(null != root){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // 后序：左子树--->右子树--->根节点
    private void postOrder(BTNode root){
        if(null != root){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    private int getNodeCount(BTNode root){
        if(null == root){
            return 0;
        }

        return  getNodeCount(root.left) + getNodeCount(root.right) + 1;
    }

    private int getLeafNodeCount(BTNode root){
        if(null == root){
            return 0;
        }

        // root就是一个叶子节点
        if(null == root.left && null == root.right){
            return 1;
        }

        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    private int getKLevelNodeCount(BTNode root, int k){
        if(null == root || k < 1){
            return 0;
        }

        // 求第一层中节点的个数
        if(1 == k){
            return 1;
        }

        // 到root的子树中求k-1层节点个数
        return getKLevelNodeCount(root.left, k-1) + getKLevelNodeCount(root.right, k-1);
    }

    private int getHeight(BTNode root){
        if(null == root){
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight? leftHeight+1 : rightHeight+1;
    }

    private BTNode find(BTNode root, int val){
        if(null == root){
            return null;
        }

        // 根节点中存储的就是val，直接返回
        if(root.val == val){
            return root;
        }

        BTNode retNode = null;
        if(null != (retNode = find(root.left, val)) || null != (retNode = find(root.right, val)))
            return  retNode;

        return null;
    }

//    // 对于基础类型的参数，不能通过改变形参来修改实参
//    // 方法： 1. 将基础类型的变量  数组
//    //        2. 重新封装一种新的类型，然后将变量----放到新封装的类型中
//    public void swap(int a, int b)
//    {
//        int temp = a;
//        a = b;
//        b = temp;
//    }
//
//    public void swap(Number n)
//    {
//        int temp = n.first;
//        n.first = n.second;
//        n.second = temp;
//    }

    public static void main(String[] args) {
        int left = 10;
        int right = 20;

        int[] array = {1, 2, 3,-2, -2, -2, 4, 5, -2, -2, 6};
        BinTree bt = new BinTree(array, -2);

        /*
        Number num = new Number(left, right);

        bt.swap(left, right);
        bt.swap(num);
        */

        if(bt.isCompleteTree()){
            System.out.println("bt is complete tree!!!");
        }
        else
        {
            System.out.println("bt is not complete tree!!!");
        }
        bt.LevelOrder();
        bt.preOrder();
        bt.preOrderNor1();
        bt.preOrderNor2();


        bt.inOrder();
        bt.inOrderNor();

        bt.postOrder();
        bt.postOrderNor();

        System.out.println(bt.getNodeCount());
        System.out.println(bt.getLeafNodeCount());
        System.out.println(bt.getKLevelNodeCount(3));
    }
}
