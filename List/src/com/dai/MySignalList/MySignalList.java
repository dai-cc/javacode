package com.dai.MySignalList;

class MySignalList {
    /*
     * 单链表
     * */
    public ListNode head;
    public MySignalList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        /*
         * 是不是第一次插入（判断head是否为空）
         * 判断*/
        ListNode node = new ListNode(data);
        if(head!=null){
            node.next=this.head;
            this.head=node;
        }else{
            this.head=node;
        }
    }


    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur=this.head;
        if(head==null){
            this.head=node;
        }else{
            while(cur.next!=null) {
                cur = cur.next;
            }
            cur.next=node;
        }
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

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur.next!=null){
            if(cur.data==key){
                return true;
            }else{
                cur=cur.next;
            }
        }
        return false;
    }


    //得到单链表的长度
    public int getLength(){
        int count=0;
        ListNode cur=this.head;
        while(cur.next!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }


    //在链表找到要插入节点位置的前一个节点
    private ListNode searchIndex(int index) {
        ListNode cur = this.head;
        //cur -> index-1
        int count = 0;
        while(count<index-1){
            count++;
            cur=cur.next;
        }
        return cur;
    }
    //插入链表指定位置
    public boolean addIndex(int index,int data){
        ListNode node=new ListNode(data);
        if(index < 0 || index > getLength()){
            System.out.println("位置不合法");
            return false;
        }
        if(index==0){
            addFirst(data);
            return true;
        }
        //找到index-1的位置
        ListNode cur = searchIndex(index);
        node.next=cur.next;
        cur.next=node;
        return true;
    }

/*    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //判断单链表是否为空

        //判断删除节点是否为头结点

        //找到KEY的前驱节点 如果没有要删除的数字

        //删除节点
    }*/

    //处理内存泄漏问题  回收这些对象
    public void clear(){
        //温柔版 一个一个置空
        while(this.head != null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head=cur;
        }
        //暴力版
        //this.head=null;
    }

    //找要删除节点的前驱节点
    private ListNode searchPrev(int key) {
        ListNode prev=this.head;
        while(prev.next!=null){
            if(prev.next.data==key) {
                return prev;
            }else{
                prev=prev.next;
            }
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //判断单链表是否为空
        if(this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //1、找到key的前驱  如果返回空
        ListNode prev = searchPrev(key);
        if(prev==null){
            return;
        }//2、删除节点
        ListNode del=prev.next;
        prev.next=del.next;

    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev=this.head;
        ListNode cur=prev.next;//想换成prev.next
        while(cur!=null) {
            if (prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }
            if (prev.next.data != key) {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data==key){
            head=cur;
            cur=cur.next;
        }
    }


    //反转单链表
    public ListNode reverseList(){
        ListNode prev=null;
        ListNode newHead=null;
        ListNode cur=this.head;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        display2(newHead);
        return newHead;
    }
    //打印反转后的单链表
    public void display2(ListNode newHead){
        ListNode cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    //找中间节点
    public ListNode middleNode(){

        ListNode fast=this.head;
        ListNode slow=this.head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    //找倒数第K个节点
    public ListNode FindKthToTail(int k){
        if(head==null || k <= 0){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k-1>0){
            if(fast.next != null){
                fast=fast.next;
                k--;
            }else{
                System.out.println("没有此节点");
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    // 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。[OJ链接]
    public ListNode partition(int x){
        ListNode cur=this.head;
        ListNode beforeStart=null;
        ListNode beforeEnd=null;
        ListNode afterStart=null;
        ListNode afterEnd=null;
        while(cur!=null){
            if(cur.data<x){
                if(beforeStart==null){
                    //如果第一次插入
                    beforeStart=cur;
                    beforeEnd=beforeStart;
                }else{
                    //不是第一次插入
                    beforeEnd.next=cur;
                    beforeEnd=beforeEnd.next;
                }
            }else {
                if(afterStart==null){
                    //第一次插入
                    afterStart=cur;
                    afterEnd=afterStart;
                }else{
                    afterEnd.next=cur;
                    afterEnd=afterEnd.next;
                }
            }
            cur=cur.next;
        }
        if(beforeStart==null){
            this.head=afterStart;
            return afterStart;
        }
        beforeEnd.next=afterStart;
        //如果afterStart不为空的话说明第二段afterEnd有值 为了防止没有尾节点 所以强制将afterEnd置空
        if(afterStart!=null){
            afterEnd.next=null;
        }
        this.head=beforeStart;
        return beforeStart;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 [OJ链接]
    public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);//创建一个虚拟节点 将不重复的节点都串到上面
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                //1、循环
                //2、退出循环 cur要多走一步
                while(cur.next!=null && cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        node=node.next;
        this.head=node;
        tmp.next=cur;//把链表尾节点置为空（因为退出循环之后cur为空）
        return node;
    }


    //判断链表的回文结构。[OJ链接]
    public boolean chkPalindrome() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        //找出链表中间节点
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            //反转
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇
        while(slow!=this.head){
            if(slow.data==this.head.data) {
                slow = slow.next;
                this.head = this.head.next;
            }else {
                return false;
            }
        }
        return true;
    }

    //判断链表是否有环
    public boolean hasCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast) {
                return true;
            }
        }
        return false;
    }

    //建一个有环的链表
    public void creatLoop(){
        ListNode cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
    }

    //找环的入口点
    public ListNode delectCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast) {
                slow=this.head;
                break;
            }
        }

        if (fast == null || fast.next==null) {
            return null;
        }

        while(fast != slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    //求带环链表环的长度
    public int len(){
//        ListNode fast=this.head;
//        ListNode listNode = this.delectCycle();
//        int count=1;
//        while(fast!=listNode){
//            fast=fast.next;
//            count++;
//        }
//
//        fast=fast.next;
//        while(fast!=listNode){
//            fast= fast.next;
//            count++;
//        }
//        return count;
        ListNode fast=this.head;
        ListNode slow=this.head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast) {
                break;
            }
        }
        if (fast == null || fast.next==null) {
            return -1;
        }
        int count = 1;
        fast=fast.next;
        while(fast != slow){
            fast=fast.next;
            count++;
        }
        return count;
    }

}//单链表


