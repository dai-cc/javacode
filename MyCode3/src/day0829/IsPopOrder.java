package day0829;

import java.util.Stack;

/*借助一个辅助的栈，遍历压栈的顺序，依次放进辅助栈中。
        对于每一个放进栈中的元素，栈顶元素都与出栈的popIndex对应位置的元素进行比较，
        是否相等，相等则popIndex++，再判断，直到为空或者不相等为止。
*/
public class IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        // 如果出入栈序列为空，则直接返回false
        if(pushA.length == 0 || popA.length == 0){
            return false;
        }
        // 建一个辅助栈
        Stack<Integer> s = new Stack<>();
        // 标识弹出序列中的位置
       int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            // 辅助栈不为空，且栈顶元素等于popA[popIndex]
            while (!s.empty() && s.peek() == popA[popIndex]) {
                // 出栈顺序指针后移, 栈顶元素出栈
                popIndex++;
                s.pop();
            }
        }
        // 此时如果辅助栈为空，说明popA是正确出栈序列，不为空说明不是
        return s.empty();
    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }
}
