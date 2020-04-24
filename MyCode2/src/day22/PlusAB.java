package day22;


public class PlusAB {
    public ListNode plusAB(ListNode a, ListNode b) {
        int flg = 0;
        ListNode head = null;
        ListNode cur = head;

        while(a!=null &&b!=null) {
            int val = a.val + b.val + flg;

            if(head == null){
                head = new ListNode(val);
                cur = head;
            }else{
                cur.next = new ListNode(val + flg);
                cur = cur.next;
            }

            if(val >= 10){
                val -= 10;
                flg = 1;
            }else{
                flg = 0;
            }

            a = a.next;
            b = b.next;
        }

        //退出说明已经有一个遍历完了
        while(a!=null){
            //如果是a没有遍历完
            int val = a.val +flg;
            if(val >= 10){
                val -= 10;
                flg = 1;
            }else{
                flg = 0;
            }
            cur.next = new ListNode(val);
            if(flg == 1){
                cur.next = new ListNode(0);
                val += 1;
                cur = cur.next;
            }else {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            if(val >= 10){
                val -= 10;
                flg = 1;
            }else{
                flg = 1;
            }
            cur.val += val;
            a = a.next;
        }

        while(b!=null){
            //如果是b没有遍历完
            int val = b.val;
            if(flg == 1){
                cur.next = new ListNode(0);
                val += 1;
                cur = cur.next;
            }else {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            if(val >= 10){
                val -= 10;
                flg = 1;
            }else{
                flg = 1;
            }
            cur.val += val;
            b = b.next;
        }

        //ab都便利完了
        if(a == null && b == null){
            if(flg == 1){
                cur.next = new ListNode(flg);
                cur = cur.next;
            }
        }
        return head;
    }
}