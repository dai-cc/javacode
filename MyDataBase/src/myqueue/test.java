package myqueue;

import java.util.LinkedList;
import java.util.Queue;

public class test {
    //用
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        System.out.println(q.isEmpty());
        System.out.println(q.size());

        //入队
        q.offer("111");
        q.offer("222");
        q.offer("333");
        q.offer("444");

        System.out.println(q.size());
        System.out.println(q.isEmpty());

        //取队头元素
        System.out.println(q.peek());

        //出队列
        q.poll();

        //取队头元素
        System.out.println(q.peek());
    }

}
