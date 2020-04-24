package day22;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ListAPlusB {
    public ListNode plusAB(ListNode a, ListNode b) {
        boolean flg = false;
        ListNode head = null;
        ListNode cur = head;

        while(a!=null &&b!=null) {
            int val = a.val + b.val;
            if(head == null){
                if(flg){
                    head = new ListNode(1);
                    cur = head;
                }else{
                    head = new ListNode(0);
                    cur = head;
                }
            }else{
                if(flg){
                    cur.next = new ListNode(0);
                    val+=1;
                    cur = cur.next;
                }else{
                    cur.next = new ListNode(0);
                    cur = cur.next;
                }
            }
            if(val >= 10){
                val -= 10;
                flg = true;
            }else{
                flg = false;
            }
            cur.val += val;
            a = a.next;
            b = b.next;


//            while (len > 0) {
//                a = a.next;
//                b = b.next;
//
//                if (val < 10) {
//                    cur = new ListNode(val);
//                } else {
//                    flg = 1;
//                    cur = new ListNode(val - 10);
//                }
//                len--;
//            }
        }
        //退出说明已经有一个遍历完了
        while(a!=null){
            //如果是a没有遍历完
            int val = a.val;
            if(flg){
                cur.next = new ListNode(0);
                val += 1;
                cur = cur.next;
            }else {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            if(val >= 10){
                val -= 10;
                flg = true;
            }else{
                flg = false;
            }
            cur.val += val;
            a = a.next;
        }

        while(b!=null){
            //如果是b没有遍历完
            int val = b.val;
            if(flg){
                cur.next = new ListNode(0);
                val += 1;
                cur = cur.next;
            }else {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            if(val >= 10){
                val -= 10;
                flg = true;
            }else{
                flg = false;
            }
            cur.val += val;
            b = b.next;
        }

        //ab都便利完了
        if(a == null && b == null){
            if(flg){
                cur.next = new ListNode(1);
                cur = cur.next;
            }
        }
        return head;
    }
}