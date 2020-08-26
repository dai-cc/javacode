package day0826;

/*
输入一个链表，反转链表后，输出新链表的表头。
*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        // 注意要判断链表为空或链表长度为1的情况
        if(head == null || head.next == null){
            return head;
        }
        // 反转单链表需要三个指针
        // cur标识当前待返转的结点
        // pre标识上一个反转好的结点
        // next标识下一个要反转的结点（因为如果不标记下一个结点的话，指向改变之后后面的链表就无法找到了）
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;//最后cur==null退出循环，pre在原链表的最后一个结点，所以返回的是pre
    }
}
