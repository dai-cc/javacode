package day22;
/*
* 判断字符串B中是否包含字符串A（小红想买的所有珠子），可以打乱顺序
* 每个输入包含1个测试用例，每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串
* 如果可以买，则输出Yes,并输出多了多少珠子
* 如果不可以买，则输出No,以及缺了多少珠子
* */

import java.util.HashMap;
import java.util.Scanner;

public class BuyOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            //将店主的珠串存放在hashmap中，
            //key代表珠子种类，value代表珠子数量
            HashMap<Character,Integer> hm = new HashMap<>();
            for (int i = 0; i < str1.length(); i++) {
                int value = hm.getOrDefault(str1.charAt(i),0) + 1;
                hm.put(str1.charAt(i),value);
            }
            //店主的珠串存储完之后，开始减去小红需要的珠串
            boolean flg = true;
            int lessCount = 0;
            for (int i = 0; i < str2.length(); i++) {
                int value = hm.getOrDefault(str2.charAt(i),0) - 1;
                //注意这个地方要先判断-1操作结束之后value的值，如果直接<0说明没有这种珠子
                //设置一个标志位表示少了这种珠子
                if(value < 0){
                    flg = false;
                    lessCount++;
                }
                hm.put(str2.charAt(i),value);
            }
            int count = 0;
            //最后将hm中的value集遍历相加，得到的值>=0 && flg,输出Yes,<0输出No
            for (Integer x:hm.values()) {
                count += x;
            }
            if(count >= 0 && flg){
                System.out.println("Yes "+count);
            }else{
                System.out.println("No "+lessCount);
            }
        }
    }
}
