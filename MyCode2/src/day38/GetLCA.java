package day38;

import java.util.Stack;

/*
* 找最近公共祖先
* 有一颗无穷大的满二叉树，其节点按根节点一层一层从左往右编号
* 根节点编号为1，现有两个节点a,b
* 求a,b得最近公共祖先得编号
* */
public class GetLCA {
    // 可以跑过
    // 思路：满二叉树的子节点与父结点之间的关系 root = child/2
    // 如果a!=b,就让其中较大数/2，最终的结果就是最近的公共祖先
    public static int getLCA(int a, int b) {
        while (a != b){
            while(a > b){
                a /= 2;
            }
            while(b > a){
                b /= 2;
            }
        }
        return a;
    }
    private static void getAncestors(int a,Stack<Integer> s){
        while (a > 0){
            s.push(a);
            if(a % 2 == 0 ){
                a /= 2;
            }else {
                a = (a-1) / 2;
            }
        }
    }
    // 测试没跑过
    public static int getLCA1(int a, int b) {
        // write code here
        // 先找出从该节点到根节点的一条路，并保存途径节点至栈中（最终栈顶元素都是1）
        // 然后从栈顶开始遍历，判断当前栈顶元素是否相等
        // 相等说明该节点是他们的公共节点，用ancestor标记
        // 然后取下一个栈顶元素判断相等，若相等则标记，不相等则说明之前标记的ancestor就是栈顶元素
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        getAncestors(a,s1);
        getAncestors(b,s2);

        int ancestor = 0;
        while(!s1.empty() && !s2.empty()){
            //当两个都不为空时
            if(s1.peek() == s2.peek()){
                ancestor = s1.peek();
                s1.pop();
                s2.pop();
            }else {
                break;
            }
        }
        return ancestor;
    }

    public static void main(String[] args) {
        System.out.println(getLCA1(14,4));
        System.out.println(getLCA(14,4));
    }
}
