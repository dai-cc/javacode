package com.dai.MyDoubleList;

import com.dai.MyDoubleList.ListNode;

class DoubleList {
    public ListNode head;//头
    public ListNode last;//尾巴
    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    //打印链表
    public void display() {
        if(this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    private ListNode searchIndex(int index){
        ListNode cur = this.head;
        if(index<0||index>getlength()){
            return null;
        }
        while(index>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
 //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        ListNode node=new ListNode(data);

        if(index==0){
            addFirst(data);
        }
        if(index==getlength()){
            addLast(data);
        }

        ListNode cur=searchIndex(index);
        if(cur==null){
            return false;
        }
            node.next=cur;
            cur.prev.next=node;
            node.prev=cur.prev;
            cur.prev=node;

    return true;
    }

    //得到双向链表的长度
    public int getlength(){
        int count=0;
        if(this.head == null) {
            return 0;
        }
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

//查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

//删除第一次出现关键字为key的节点 并返回删除的节点的data值
    public int remove(int key){
        //删头 删尾 删中间
        int oldData=-1;//用来存储要删除的数字
        ListNode cur = this.head;
        while(cur!=null){
            if(cur.data==key) {
                oldData = cur.data;

                if(cur==this.head){//删的是头
                    this.head=this.head.next;
                    this.head.prev=null;
                    return oldData;
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {//删除的是中间
                       cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                    return oldData;
                }
            }
            cur=cur.next;
        }
        return -1;
    }

//删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                if(this.head==cur){//删除的是头
                    this.head=this.head.next;
                    this.head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        this.last=cur.prev;
                    }
                    cur.next.prev=cur.prev;
                }
            }
            cur=cur.next;
        }
    }

    //清空链表   防止内存泄露
//处理内存泄漏问题  回收这些对象
    public void clear(){
    //一个一个置空
        while(this.head != null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head.prev=null;
            this.head=cur;
        }
        this.head=null;
    }
}
//JDK的命令 java javac javap-c jps jmap

