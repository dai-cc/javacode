package com.dai;

class myListNode{
    int val;
    myListNode next;
    myListNode(int val){
        this.val = val;
    }
}
public class myLinkedList {
    /** Initialize your data structure here. */
    //设计一个带头结点的单链表，有一个属性记录链表的大小
    int size;
    myListNode head;
    myLinkedList() {
        size = 0;
        head = new myListNode(0);
    }

    public int get(int index) {
        //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
        //先判断索引是否有效(index >= 0 && index < size))
        //如果无效则返回-1
        //有效找到
        if(index < 0 || index >= size){
            return -1;
        }
        myListNode cur = head;
        while(index >= 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        //addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
        myListNode insert = new myListNode(val);
        myListNode pre = head;
        if(index > size){
            return;
        }
        if(index < 0){
            //如果位置为负数，则将它插在链表头
            index = 0;
        }
        //因为要加入元素，所以size++
        size++;

        //开始找要插入位置的头一个节点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        insert.next = pre.next;
        pre.next = insert;
    }

    public void deleteAtIndex(int index) {
        //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
        myListNode cur = head;
        if(index < 0 || index >= size){return;}
        while(index > 0){
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
    }
}

