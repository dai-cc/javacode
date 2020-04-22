package day20;

import java.util.HashMap;
import java.util.Scanner;

/*
* 收到的红包中有一个金额出现次数超过了收到红包总数的一半
* 设计一个算法求这个红包金额是多少
* 给定红包金额数组gifts和红包数n
* 输出：返回所求红包金额
*       若没有超过一半的则返回0*/
public class Gifts {
    public static int getValue(int[] gifts, int n) {
        //将数组中的元素往hashmap中存放
        //存放之前先判断这个数是否存在，如果存在value++,并判断value>(n/2)
        //如果大于，则直接返回value所对应的value
        //小于则继续
        //如果所有元素都添加完了还没有发现出现次数>红包总数的一半，直接返回0
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = hm.getOrDefault(gifts[i],0);
            hm.put(gifts[i],++value);
            if(value > (n/2)){
                return gifts[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] gifts = {1,2,3,2,2};
        int n = 5;
        System.out.println(getValue(gifts,n));
    }
}
