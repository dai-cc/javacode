package day3;

import java.util.LinkedList;
import java.util.Queue;

/*
二叉树的镜像
*/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class BTMirror {
    public void Mirror1(TreeNode root) {
        if(null == root){
            // 空树直接返回
            return;
        }

        // 交换根的左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归交换子树的左右子树
        Mirror1(root.left);
        Mirror1(root.right);
    }

    // 方法二：层序遍历
    public void Mirror(TreeNode root) {
        if(null == root){
            // 空树直接返回
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            // 取出对头元素
            TreeNode cur = q.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if(null != cur.left){
                q.offer(cur.left);
            }
            if(null != cur.right) {
                q.offer(cur.right);
            }

        }
    }
}
