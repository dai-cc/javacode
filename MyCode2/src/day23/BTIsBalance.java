package day23;

import java.util.*;

/*
* 实现一个函数，检查二叉树是否平衡，
* 平衡的定义是指对于树中任意一个节点，两个子树的高度差不超过1
* */
class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;
    public TreeNode1(int val) {
        this.val = val;
    }
}

public class BTIsBalance {
    //计算树的高度
    private int height(TreeNode1 root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
    public boolean isBalance(TreeNode1 root) {
        if(root == null){
            return true;
        }
        if(Math.abs(height(root.left)-height(root.right)) > 1){
            //如果子树的高度差超过1，则返回false
            return false;
        }
        return true;
    }
}
