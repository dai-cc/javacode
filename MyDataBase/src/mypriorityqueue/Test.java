package mypriorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        //插入失败的时候会返回false或抛出异常
        //插入元素期间，优先级队列中的元素会进行调整，首元素一定是最小的
        p.offer(1);
        p.offer(2);
        p.offer(3);
        p.offer(4);
        p.offer(5);
        p.offer(6);

        //peek始终取的是优先级队列中第一个的元素
        System.out.println(p.peek());

        p.poll();
        System.out.println(p.peek());

        p.clear();
        System.out.println(p.isEmpty());
    }
    public static void main1(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //创建一个空的优先级队列，默认大小为11

        PriorityQueue<Integer> p2 = new PriorityQueue<>(20);
        //如果知道优先级队列中大概要放多少个元素，最好使用该方法进行构造
        //不要使用空的构造方式构造，因为在插入元素是需要不断地扩容而影响程序效率


        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        PriorityQueue<Integer> p3 = new PriorityQueue<>(l);
        System.out.println(p3.size());
        //可以用一个集合来直接构造优先级队列，
        // 将来就会将集合中的元素放到优先级队列中

    }
}
