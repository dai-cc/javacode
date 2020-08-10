package day4;

/*
* 二叉树的最近公共祖先
* 给定一个二叉树，找到该树种两个指定结点的最近公共祖先
* */
public class lowestCommonAncestor {
    // 方法一：
/*    // 先获取到p,q结点的路径
    public boolean nodePath(TreeNode root, TreeNode node, Stack<TreeNode> path){
        if(null == root){
            // 树为空返回null
            return false;
        }
        // 将当前结点入栈
        path.push(root);
        if(node == root){
            // 如果当前遍历到的结点root就是最终结点node
            // root因为不断递归所以root不是最开始的根节点了，而是遍历到的当前结点
            return true;
        }
        if(nodePath(root.left,node,path) || nodePath(root.right,node,path)){
            // 在root的左子树中找node没找到就在右子树中找，找到了返回true
            return true;
        }
        // 没在树中找到node，所以之前压栈的结点要删掉
        path.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root ||null == p ||null == q){
            return null;
        }
        Stack<TreeNode> pPath = new Stack<>();
        nodePath(root,p,pPath);

        Stack<TreeNode> qPath = new Stack<>();
        nodePath(root,q,qPath);

        int pSize = pPath.size();
        int qSize = qPath.size();

        while (pSize > 0 && qSize > 0){
            if(pSize > qSize){
                pPath.pop();
                pSize--;
            }else if(pSize < qSize){
                qPath.pop();
                qSize--;
            }else{
                if(pPath.peek() == qPath.peek()){
                    return pPath.peek();
                }else{
                    pPath.pop();
                    qPath.pop();
                    pSize--;
                    qSize--;
                }
            }
        }
        return null;
    }*/

    // 方法二：
    // 检测node在树中的哪个位置
    // （检测在哪个位置只需要改变传参，传参是左/右子树的结点就是查找是否是在左/右子树中）
    private boolean isInTree(TreeNode root,TreeNode node){
        if(root == null){
            return false;
        }
        if(root == node){
            return true;
        }
        if(isInTree(root.left,node) || isInTree(root.right,node)){
            return true;
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || null == p || null == q){
            return null;
        }
        if(root == p || root == q){return root;}
        boolean pInLeft = false;
        boolean pInRight = false;
        boolean qInLeft = false;
        boolean qInRight = false;

        // 检测p在左子树还是右子树
        if(isInTree(root.right,p)){
            // p在右子树中
            pInRight = true;
        } else{
            pInLeft = true;
        }

        // 检测q在左子树还是右子树
        if(isInTree(root.right,q)){
            // p在右子树中
            qInRight = true;
        } else{
            qInLeft = true;
        }

        if((pInLeft && qInRight) || (pInRight && qInLeft)) {
            // p,q分别在root的左右子树中--》最近的公共祖先就是root
            return root;
        } else if(pInLeft && qInLeft) {
            // p,q在root的左子树中--》递归到根节点的左子树中找
            return lowestCommonAncestor(root.left,p,q);
        } else{
            // p,q在root的右子树中--》递归到根节点的右子树中找
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}
