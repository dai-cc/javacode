package moniTest;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
* 最小的K个数
* 输出n个整数，找出其中最小的K个数
* TOPK问题，优先级队列
* */
public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> l = new ArrayList<>();
        int len = input.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            l.add(input[i]);
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> l = new ArrayList<>();
        l = GetLeastNumbers_Solution(arr,4);
    }
}