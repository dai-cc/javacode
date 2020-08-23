package day0823;

import java.util.Arrays;

/*重建二叉树
* 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
* 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
* 则重建二叉树并返回。*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // 1. 前序遍历可以得到根节点
        // 2. 在中序遍历中找第一步中得到的根节点的位置，然后以此为界，
        // 将数组分成左右两半部分，左边是该根的左子树，右边是右子树
        // 3. 递归创建跟的左右子树
        // 树的问题要先判空
        if(pre.length==0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                // 递归创建根的左右子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }
    public static void main(String[] args) {
        // 1. 前序遍历可以得到根节点
        // 2. 在中序遍历中找第一步中得到的根节点的位置，然后以此为界，
        // 将数组分成左右两半部分，左边是该根的左子树，右边是右子树
        // 3. 递归创建跟的左右子树
    }
}
