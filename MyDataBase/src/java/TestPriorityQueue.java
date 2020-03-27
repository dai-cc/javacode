/**
 * @Author: will
 * @Date: 2020/3/17
 * @description:
 */


import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.List;

import java.util.Comparator;



class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo(Card o){

        // 拍面值
        return rank - o.rank;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }

        if(null == o || !(o instanceof Card)){
            return false;
        }

        Card card = (Card)o;
        return rank == card.rank &&
                suit.equals(card.suit);
    }
}


// 基于比较器的比较
class CardComp implements Comparator<Card>{

    @Override
    public int compare(Card o1, Card o2) {
        if(o1 == o2){
            return 0;
        }

        if(null == o1){
            return  -1;
        }

        if(null == o2){
            return 1;
        }


        return o2.rank - o1.rank;
    }
}


public class TestPriorityQueue {
    public static void TestPriorityQueue1(){
        // 1. 构造一个空的优先级队列---注意：空的优先级队列，但是底层已经有了11个默认空间
        PriorityQueue<Integer> p1 = new PriorityQueue<>();

        // 2. 按照指定容量来进行构造
        //    如果知道优先级队列中大概要放多少个元素，最好使用该中方式进行构造
        //    不要使用空的构造方式构造，因为在插入元素时需要不断扩容而影响程序的效率
        PriorityQueue<Integer> p2 = new PriorityQueue<>(20);

        // 3. 可以用一个集合来直接构造优先级队列，将来就会将集合中的元素放到优先级队列
        List<Integer> L = new ArrayList<>();
        L.add(4);
        L.add(0);
        L.add(3);
        L.add(2);
        L.add(1);

        // 使用List构造优先级队列时，优先级队列并不是直接将List中的元素拷贝进来
        // 而是将List中的元素按照一定的规则进行排列
        PriorityQueue<Integer> p3 = new PriorityQueue<>(L);
        System.out.println(p3.size());
    }

    public static void TestProrityQueue2(){
        PriorityQueue<Integer> p = new PriorityQueue<>();

        // 注意：插入的元素一定要能够比大小，而且不能插入null对象
        //       插入时会自动进行扩容
        //       插入的时间复杂度O(logN)
        //       插入失败时候：返回false 或者 抛出异常
        //       插入元素期间，优先级队列中的元素会进行调整，首元素一定是最小的
        p.offer(4);
        p.offer(1);
        p.offer(3);
        p.offer(0);
        p.offer(5);
        p.offer(2);

        // peek(): 取优先级队列中第一个(最小的)元素
        System.out.println(p.peek());

        // poll(): 删除优先级队列中第一个元素(最小的)元素
        //         剩余元素会自动进行调整--->将剩余元素中最小的元素调整到首元素位置
        //         时间复杂度：O(logN)
        p.poll();  //删除一个元素
        System.out.println(p.peek());
        p.poll();  //删除一个元素
        System.out.println(p.peek());

        p.clear();
        if(p.isEmpty()){
            System.out.println("优先级队列已经为空!");
        }
        else{
            System.out.println("优先级队列不为空!");
        }
    }

    public static void TestPriorityQueue3()
    {
        PriorityQueue<Card> q = new PriorityQueue<Card>();
        q.offer(new Card(5, "♠"));
        q.offer(new Card(6, "♠"));
        q.offer(new Card(4, "♠"));
    }

    public static void TestCompare2()
    {
        Card c1 = new Card(1, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = c1;
        Card c4 = new Card(1, "♠");

        if(c1.equals(c4)){
            System.out.println("c1 == c4");
        }
        else{
            System.out.println("c1 != c4");
        }

        System.out.println(c1 == c2);
        System.out.println(c1 != c2);
        //System.out.println(c1 == c4);
        System.out.println(c1.compareTo(c2));
    }

    public static void TestCompare3() {
        Card c1 = new Card(1, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = c1;
        Card c4 = new Card(1, "♠");

        // 如果要比较，先要给一个比较器的对象
        CardComp comp = new CardComp();
        if(comp.compare(c1, c2) > 0){
            System.out.println("c1 > c2");
        }
        else if(comp.compare(c1, c2) == 0){
            System.out.println("c1 == c2");
        }
        else{
            System.out.println("c1 < c2");
        }
    }


    public static void TestCompare1() {
        int a = 10;
        int b = 20;
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);

        char c1 = 'A';
        char c2 = 'B';
        System.out.println(c1 > c2);
        System.out.println(c1 < c2);
        System.out.println(c1 == c2);

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 == b2);
        System.out.println(b1 != b2);

    }

    static public void TestPriporityQueue4(){
        Card c1 = new Card(5, "♠");
        Card c2 = new Card(2, "♠");
        Card c3 = new Card(1, "♠");
        Card c4 = new Card(3, "♠");

        PriorityQueue<Card> p1 = new PriorityQueue<>(4);
        p1.offer(c1);
        p1.offer(c2);
        p1.offer(c3);
        p1.offer(c4);

        // 大堆
        PriorityQueue<Card> p2 = new PriorityQueue<>(4, new CardComp());
        p2.offer(c1);
        p2.offer(c2);
        p2.offer(c3);
        p2.offer(c4);
    }

    public static void main(String[] args) {
        //TestPriorityQueue1();
        //TestProrityQueue2();

        // TestPriorityQueue3();
        //TestCompare1();

       // TestCompare2();

        // TestCompare3();
        TestPriporityQueue4();
    }
}
