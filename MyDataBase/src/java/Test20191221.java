package java;
import java.util.*;

/**
 * @Author: will
 * @Date: 2019/12/24
 * @description:
 */
import java.util.ArrayList;

/*
public class Test20191224 {
    public static void main(String[] args) {
        ArrayList<String> L1 = new ArrayList<>();
        List<String> L2 = new ArrayList<>();

        L1.add("1111");
        L1.add("2222");
        L1.add("2222");
        L1.add("2222");

        L2.add("1111");
        L2.add("1111");
        L2.add("1111");
    }
}
*/

/*
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Test20191221 {
    public static void main(String[] args) {
        // List<Integer> L = new ArrayList<>();

        List<Integer> L = new LinkedList<>();
        // 尾插
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        System.out.println(L);
        System.out.println(L.size());

        // 获取任意位置上的元素index :[0, size())
        System.out.println(L.get(0));
        //System.out.println(L.get(10));

        // 任意位置的插入
        L.add(0, 0);
        System.out.println(L);

        L.remove(1);
        System.out.println(L);

        if(L.contains(1)){
            System.out.println("remove: 失败");
        }
        else{
            System.out.println("remove: 成功");
        }

        L.add(0);
        System.out.println(L.indexOf(0));
        System.out.println(L.lastIndexOf(0));

        // 0 2 3 4 0---》
        // [1, 3)
        List<Integer> ret = L.subList(1,3);
        System.out.println(ret);
    }
}
*/

/*
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


// 牌的结构
class Card{
    Card(String suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        String strNum = String.format("%d", rank);

        switch(rank)
        {
            case 11:
                strNum = "J";
                break;
            case 12:
                strNum = "Q";
                break;
            case 13:
                strNum = "K";
                break;
        }

        return suit + ":" + strNum;
    }

    private String suit;  // 代表牌的花色
    private int rank;    //  代表牌面值
}


class CardDeam{
    // 构造一幅扑克牌
    String Color[] = {"♥", "♦", "♣", "♠"};

    public List<Card> BuyDeck()
    {
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < 4; ++i){
            for(int j = 1; j <= 13; ++j){
                // 牌面值 和 牌的花色
                Card c = new Card(Color[i], j);
                cards.add(c);
            }
        }

        return cards;
    }

    // 洗牌
    public void shuffleCard(List<Card> cards){
        for(int i = cards.size()-1; i > 0; i--){

            // 从[0，i)区间中随机取一张牌
            // 常见设置种子方式：获取系统当前时间
            Random r = new Random(20191224);
            int j = r.nextInt(i);

            // 将i和j位置的牌进行交换
            Swap(cards, i, j);
        }
    }

    private void Swap(List<Card> cards, int i, int j){
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }
}
public class Test20191221 {
    public static void main(String[] args) {
        CardDeam cd = new CardDeam();

        // 构造一幅扑克牌
        List<Card> L = cd.BuyDeck();

        // 打印扑克牌
        System.out.println(L);

        cd.shuffleCard(L);
        System.out.println(L);

        // 3个人---每个人摸5张牌 抓牌
        List<List<Card>> hands = new ArrayList<>();
        for(int i = 0; i < 3; ++i)
            hands.add(new ArrayList<>());

        for(int i = 0; i < 5; ++i){
            // 3个人一次摸牌
            for(int j = 0; j < 3; ++j){
                // 从L中依次获取一张牌---》
                Card card = L.remove(L.size()-1);
                // 将该张牌放置到对应人的手中
                hands.get(j).add(card);
            }
        }

        // 打印每个人手中的牌
        for(int i = 0; i < hands.size(); ++i){
            System.out.println(hands.get(i));
        }
        // 牌摞摞中剩余什么牌
        System.out.println(L.size());
        System.out.println(L);
    }
}
*/

/*
import java.util.Stack;


class Solution {
    public boolean isValid(String s) {
        Stack<Character> ss = new Stack();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);

            // 左括号入栈
            if(ch == '(' || ch == '[' || ch == '{')
                ss.push(ch);
            else
            {
                // ch是右括号
                // 如果栈是空：右括号比左括号多
                if(ss.empty()){
                    return false;
                }

                char chLeft = ss.peek();
                // 检测ch的右括号与chLeft左括号释放匹配
                if(chLeft == '(' && ch == ')' ||
                        chLeft == '[' && ch == ']' ||
                        chLeft == '{' && ch == '}'){
                    ss.pop();
                }
                else
                {
                    // 左右括号次序匹配有问题
                    return false;
                }
            }
        }

        if(!ss.empty()){
            // 左括号比右括号多
            return  false;
        }

        return true;
    }
}

public class Test20191221 {
    public static void main(String[] args) {
        Stack<String> s = new Stack();
        System.out.println(s.size());
        System.out.println(s.empty());
        System.out.println(s.peek());

        s.push("1111");
        s.push("2222");
        s.push("3333");
        s.push("4444");
        s.push("5555");

        System.out.println(s.size());
        System.out.println(s.empty());
        System.out.println(s.peek());

        // 删除栈顶元素
        s.pop();
        System.out.println(s.size());
        System.out.println(s.peek());
    }
}
*/

/*
class Node{
    public Node(int data)
    {
        next = null;
        this.data = data;
    }

    public int data;
    public Node next;
}

public class Test20191221 {
    public static void Print1(Node head)
    {
        if(head != null){
            Print1(head.next);
            System.out.println(head.data);
        }
    }

    public static void Print2(Node head)
    {
        Node cur = head;
        Stack<Node> s = new Stack();
        while(cur != null){
            s.push(cur);
            cur = cur.next;
        }

        // 将栈中的元素依次出栈
        while(!s.empty()){
            Node top = s.peek();
            System.out.println(top.data);
            s.pop();
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Print1(n1);
        Print2(n1);
    }
}
*/

/*
class MyStack<E>
{
    private E[] array = (E[])new Object[100];
    private int size = 0;

    public void push(E e)
    {
        if(size == 100)
            return;

        array[size++] = e;
    }

    public E pop()
    {
        if(empty())
            return null;

        E e = array[size-1];
        size--;
        return e;
    }

    E peek()
    {
        if(empty())
            return null;

        return array[size-1];
    }

    boolean empty()
    {
        return 0 == size;
    }

    int size(){
        return size;
    }
}

public class Test20191221 {
    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);

        System.out.println(ms.size());
        System.out.println(ms.peek());

        ms.pop();
        ms.pop();

        System.out.println(ms.size());
        System.out.println(ms.peek());
    }
}
*/

/*
import java.util.Queue;
import java.util.LinkedList;

public class Test20191221 {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        System.out.println(q.isEmpty());
        System.out.println(q.size());

        //入队列
        q.offer("1111");
        q.offer("2222");
        q.offer("3333");
        q.offer("4444");
        q.offer("5555");
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        System.out.println(q.peek());

        // 出队列
        q.poll();
        q.poll();
        q.poll();
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        System.out.println(q.peek());
    }
}
*/

// ArrayList\LinkedList  Stack  Queue
// 底层结构：带头结点的单链表
class Node<E>
{
    public Node<E> next;
    public E data;

    public Node(E e)
    {
        next = null;
        data = e;
    }

    public Node()
    {
        next = null;
    }
}

class MyQueue<E>
{
    private Node<E> front;
    private Node<E> rear;
    private int size;

    MyQueue()
    {
        front = rear = new Node<E>();
        size = 0;
    }

    boolean offer(E e)
    {
        rear.next = new Node<>(e);
        rear = rear.next;
        size++;
        return  true;
    }

    E poll()
    {
        if(isEmpty())
            return null;

        E ret = front.next.data;
        front.next = front.next.next;
        size--;
        return  ret;
    }

    E peek()
    {
        if(isEmpty())
            return  null;

        return front.next.data;
    }

    int size()
    {
        return size;
    }

    boolean isEmpty()
    {
        return  0 == size;
    }
}

public class Test20191221 {
    public static void main(String[] args) {
    }
}



