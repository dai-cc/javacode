package com.dai;
import java.util.List;

//定义一个节点类
class ListNode{
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}

//定义我的单链表
class MySinalList {
    public ListNode head;

    public MySinalList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        //判断是否是第一次插入
        if (this.head != null) {
            //说明不是第一次插入
            node.next = this.head;
            this.head = node;
        }
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if (head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    private ListNode getPre(int index) {
        int pre = 0;
        ListNode cur = this.head;
        while (pre < index - 1) {
            pre++;
            cur = cur.next;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        ListNode node = new ListNode(data);
        //先判断位置是否合法
        if (index < 0 || index >= getLength()) {
            System.out.println("位置不合法");
            return false;
        } else if (index == 0) {
            addFirst(data);
            return true;
        }
        ListNode pre = getPre(index);
        pre = pre.next;
        node.next = pre.next;
        pre.next = node;
        return true;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {
            if (cur.data == key) {
                System.out.println("已找到该关键字");
                return true;
            }
            cur = cur.next;
        }
        System.out.println("不包含该关键字");
        return false;
    }


    private ListNode getPre1(int key) {
        ListNode pre = this.head;
        while (pre.next != null) {
            if (pre.next != null && pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
//        while(pre.next.data!=key){
//            pre=pre.next;
//        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        //ListNode cur=this.head;
        //先判断链表是否为空
        if (this.head == null) {
            System.out.println("该链表为空");
            return;
        } else {
            //链表不为空，判断该关键字是否在头结点
            if (this.head.data == key) {
                this.head = this.head.next;
                return;
            }
            //不在头节点，找到该节点的前驱节点
//                while(cur.next!=null){
//                    if(cur.data==key){
//                        break;
//                    }
//                    cur=cur.next;
//                }
            if (getPre1(key) == null) {
                System.out.println("没有该节点");
                return;
            }
            ListNode pre = getPre1(key);
            ListNode cur = pre.next;
            pre.next = cur.next;

//            //该关键字存在，找到关键字所在位置
//            while(cur.next!=null && cur.data!=key){
//                cur=cur.next;
//            }
//            //退出循环 cur.next==null 或者cur.data==key
//            if(cur.next==null){
//                System.out.println("不存在该关键字");
//            }else{
//                //找到cur的前驱节点
//
//            }
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode pre = this.head;
        ListNode cur = pre.next;
        while (cur != null) {
            if(pre.next.data==key) {
                pre.next = cur.next;
                cur=cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key){
            this.head=this.head.next;
            //this.head = cur;不可以这样写 因为是最后判断的 此时cur已经移到后面了
        }
    }


//            //判断链表是否为空
//            if (this.head == null) {
//                System.out.println("该链表为空");
//                return;
//            } else {
//                //判断删除的是否为头结点
//                if (this.head.data == key) {
//                    this.head = this.head.next;
//                }
//                //不是头结点 找到其前驱节点
//                //判断是否有key存在
//                if (getPre1(key) == null) {
//                    System.out.println("没有该节点");
//                    return;
//                }
//                ListNode pre = getPre1(key);
//                ListNode cur = pre.next;
//                pre.next = cur.next;
//            }

    //得到单链表的长度
    public int getLength(){
        int count=0;
        ListNode cur=this.head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    //打印单链表
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    //反转单链表
    public ListNode reverseList(){
        ListNode pre=null;
        ListNode newHead=null;
        ListNode cur=this.head;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
            //cur=cur.next;不可以这么写 此时的cur.next已经是pre了
        }
        display1(newHead);
        return newHead;
    }

    public void display1(ListNode cur){

        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //清空单链表
    public void clear(){}

}

