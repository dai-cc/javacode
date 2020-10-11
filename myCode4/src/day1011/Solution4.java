package day1011;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode1 {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 }
/* 返回二叉树的左侧视图
* */
public class Solution4 {
    public int[] leftSideView (TreeNode1 root) {
        // write code here
        // 层序遍历
        StringBuffer sb = new StringBuffer();

        Queue<TreeNode1> q = new LinkedList<>();
        q.offer(root);

        int size = 1;
        int child = 1;
        while (!q.isEmpty()){
            child = 0;
            for (int i = 0; i < size; i++) {
                TreeNode1 node = q.poll();
                if(i == 0){
                    sb.append(node.val);
                    sb.append(" ")
                }
            }
        }
    }
}
