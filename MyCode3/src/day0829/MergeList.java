package day0829;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class MergeList {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        // 1. 建立一个虚拟头节点，作为合成表的初始头节点
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        // 2. 两个指针指向两个链表的头cur1 cur2
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            // 3. 比较两指针的val
            if(cur1.val >= cur2.val) {
                // cur1.val >= cur2.val 将cur2放入新链表中，cur2后移
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }else{
                // cur2.val > cur1.val 将cur1放入新链表中，cur1后移
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
        }
        // 退出循环说明list1遍历完了或者list2遍历完,将没遍历完的那个链表合并到新链表里就行了
        if (cur1 == null){
            // cur2没便利完
            cur.next = cur2;
        }
        if (cur2 == null){
            // cur1没便利完
            cur.next = cur1;
        }
        return newHead.next;
    }
}
