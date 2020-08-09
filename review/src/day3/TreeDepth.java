package day3;

/*
* 输入一颗二叉树，求树的深度
* （从根节点到叶节点的一条最长路径）
* */

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftH = TreeDepth(root.left);
        int rightH = TreeDepth(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    public int TreeDepth1(TreeNode root) {
        if (null == root) {
            // 空树直接返回
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            // 要保证每一层+1，而不是每一个结点都加1
            // 每次队列中保存的都是当前这一层的结点
            int size = q.size();
            while(size-- > 0) {
                // 取出对头元素
                TreeNode cur = q.poll();
                if (null != cur.left) {
                    q.offer(cur.left);
                }
                if (null != cur.right) {
                    q.offer(cur.right);
                }
            }
            // 一层遍历完层数加1
            depth++;
        }
        return depth;
    }
}