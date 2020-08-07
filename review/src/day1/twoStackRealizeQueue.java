package day1;

import java.util.Stack;

/*
* 用两个栈实现队列
* 完成队列的push和pop操作，队列中的元素为int类型
* 栈：先进后出
* 队列：先进先出*/
public class twoStackRealizeQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 入队列的时候还是正常的入
    public void push(int node) {
        stack1.push(node);
    }

    // 出队列的时候将s2作为辅助队列，
    // 将s1中所有元素都弹出到s2中，那么s2中的对头元素就应该是要弹出的数据
    // 但是如果在弹出元素之后又添加了元素，这种情况下s1不为空
    // 此时弹出元素要先保证s2中的元素弹完才能继续往s2中弹元素
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
class Test{
    public static void main(String[] args) {
        twoStackRealizeQueue q = new twoStackRealizeQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.pop();
        q.push(9);
    }
}
