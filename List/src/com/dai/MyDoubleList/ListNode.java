package com.dai.MyDoubleList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-06
 * Time: 20:52
 */
class ListNode {
    public int data;
    public ListNode prev;//前驱
    public ListNode next;//后继
    //new ListNode(10);
    public ListNode(int data) {
        this.data = data;
    }
}
