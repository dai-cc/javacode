package day20;
import java.util.*;

/*
* 分割链表
* 给定链表头pHead和x
* 要求将链表以x为基准分割成两部分，所有小于x的节点排在大于或等于x的节点之前
* 并且分割之后保持原来的数据顺序不变
* 返回新链表的头结点
* */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ListPartation {
    //注意这种写法是对的，题中只是要求小于x的排在大于等于x的前面，并没有说要小于x，x,大于x
    //所以如果结果是1，2，5，3就可以了
        public static ListNode partition(ListNode pHead, int x) {
            if(pHead == null){
                return null;
            }
            // write code here
            ListNode small=new ListNode(-1);
            ListNode big=new ListNode(-1);
            ListNode smallHead=small;
            ListNode bigHead=big;
            while(pHead!=null){
                if(pHead.val<x){
                    small.next=pHead;
                    small=small.next;
                }else{
                    big.next=pHead;
                    big=big.next;
                }
                pHead=pHead.next;
            }
            small.next = bigHead.next;
            big.next=null;
            return smallHead.next;
        }


//    public static ListNode partition(ListNode pHead, int x) {
//        // write code here
//        ListNode small=new ListNode(-1);
//        ListNode big=new ListNode(-1);
//        ListNode smallHead=small;
//        ListNode bigHead=big;
//        while(pHead!=null){
//            if(pHead.val<x){
//                small.next=pHead;
//                small=small.next;
//            }else if(pHead.val > x){
//                big.next=pHead;
//                big=big.next;
//            }
//            pHead=pHead.next;
//        }
//        ListNode cur = new ListNode(x);
//        small.next = cur;
//        cur.next = bigHead.next;
//        big.next=null;
//        return smallHead.next;
//    }

//    public static ListNode partition(ListNode pHead, int x) {
//        if (pHead == null) {
//            return null;
//        }
//        ListNode small = new ListNode(-1);
//        ListNode big = new ListNode(-1);
//
//        ListNode smallHead = small;
//        ListNode bigHead = big;
//
//        ListNode cur = pHead;
//        while (cur != null) {
//            if (cur.val < x) {
//                small.next = cur;
//                small = small.next;
//            } else if (pHead.val > x) {
//                big.next = pHead;
//                big = big.next;
//            }
//            pHead = pHead.next;
//        }
//        ListNode cur = new ListNode(x);
//        small.next = cur;
//        cur.next = bigHead.next;
//        big.next = null;
//        return smallHead.next;
//    }
    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String []args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode returnHead = partition(head, 3);
        print(returnHead);
    }
}
