package mybinarytree;

import java.util.LinkedList;
import java.util.List;

//二叉树前序遍历
public class PreOrderTraversal {
    //前序遍历根节点，左节点，右节点
    public List<Integer> preorderTraversal(TreeNode root) {
        //递归写法
        List<Integer> l = new LinkedList<>();
        mypreorderTraversal(root, l);
        return l;
    }

    public void mypreorderTraversal(TreeNode root, List<Integer> l) {
        if (null != root) {
            l.add(root.val);
            mypreorderTraversal(root.left, l);
            mypreorderTraversal(root.right, l);
        }
    }
}
