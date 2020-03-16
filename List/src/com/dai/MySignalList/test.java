package com.dai.MySignalList;
public class test {
    public static void main(String[] args) {
        MySignalList mySignalList=new MySignalList();
        mySignalList.addFirst(3);
        mySignalList.display();
        mySignalList.addFirst(7);
        mySignalList.display();
        mySignalList.addFirst(6);
        mySignalList.display();
        mySignalList.addFirst(3);
        mySignalList.display();
        mySignalList.addFirst(3);
        mySignalList.display();

        mySignalList.reverseList();


//        mySignalList.removeAllKey(3);
//        mySignalList.display();

//        MySignalList mySignalList2=new MySignalList();
//        mySignalList2.addFirst(10);
//        mySignalList2.display();
//        mySignalList2.addFirst(8);
//        mySignalList2.display();
//        mySignalList2.addFirst(5);
//        mySignalList2.display();
//        mySignalList2.addFirst(4);
//        mySignalList2.display();
//        mySignalList2.addFirst(1);
//        mySignalList2.display();
//
//
//        ListNode listNode = mergeTwoLists(mySignalList.head, mySignalList2.head);
//        System.out.println(listNode.data);
//        System.out.println(listNode.next.data);
//        System.out.println(listNode.next.next.data);

/*        mySignalList.partition(6);
        mySignalList.display();*/

/*        mySignalList.deleteDuplication();
        mySignalList.display();*/
/*
        boolean flg=mySignalList.chkPalindrome();
        System.out.println(flg);

        boolean flg2=mySignalList.hasCycle();
        System.out.println(flg2);*/

//        System.out.println(mySignalList.delectCycle());
//
//        mySignalList.creatLoop();
//        System.out.println(mySignalList.hasCycle());
//
//        System.out.println(mySignalList.delectCycle().data);
//
//       /* ListNode node = mySignalList.delectCycle();
//        System.out.println(node.data);*/
//
//        System.out.println(mySignalList.len());
//
//
//        getIntersectionNode(mySignalList.head,mySignalList2.head);
    }

    //求两条链表的交点
    public static ListNode  getIntersectionNode (ListNode headA,ListNode headB){
        if(headA == null || headB == null) {
            return null;
        }
        //永远指向最长的单链表
        ListNode pL = headA;
        //永远指向最短的单链表
        ListNode pS = headB;

        //分别求长度
        int lenA = getListNodelen(pL);

        int lenB = getListNodelen(pS);

        //求长度的差值
        int len = lenA-lenB;
        //如果是负数-》pL = headB;  pS = headA
        if(len<0){
            pL=headB;
            pS=headA;
            len=lenB-lenA;
        }
        //只需要让pL走len步就好了
        while(len>0){
            pL=pL.next;
            len--;
        }
        //走完len步之后  两个同时开始走
        //一直走 走到next值相同时 就是交点
     /*   while(pL!=null && pS!=null){
            pL=pL.next;
            pS=pS.next;
            if(pL.next==pS.next){
                return pL;
            }
        }*/
        while(pL !=null && pL!= pS){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS && pL!=null){
            return pL;
        }
        return null;
    }

    public static int getListNodelen(ListNode node){
        int len= 0;
        ListNode cur=node;
        while(cur.next!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
    //合并两个有序单链表
    public static ListNode  mergeTwoLists (ListNode headA,ListNode headB){
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while(headA!=null && headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                tmp=tmp.next;
                headA=headA.next;
            }else{
                tmp.next=headB;
                tmp=tmp.next;
                headB=headB.next;
            }
        }
        if(headA==null){
            tmp.next=headB;
        }
        if(headB==null){
            tmp.next=headA;
        }
        return node.next;

//        ListNode node=new ListNode(-1);
//        ListNode tmp=node;
//        while(headA!=null && headB!=null){
//            if(headA.data<headB.data){
//                tmp.next=headA;
//                tmp=headA.next;
//                headA=headA.next;
//            }else{
//                tmp.next=headB;
//                tmp=headB.next;
//                headB=headB.next;
//            }
//        }
//        if(headA==null){
//            tmp.next=headB;
//        }
//        if(headB==null){
//            tmp.next=headA;
//        }
//        return node.next;
    }
}
