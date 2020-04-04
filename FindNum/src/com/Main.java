package com;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //建一个hashmap，往里面放数字，key为数字，value为出现次数
            //放数字前判断是否存在该数字，存在的话改变该数字的value值，
            //不存在的话将数字存入，value置为1
            String str = sc.nextLine();
            boolean flag = false;
            String[] num = str.split(" ");
            Hashtable<String,Integer> ht = new Hashtable<>();
            for (int i = 0; i < num.length; i++) {
                if(ht.containsKey(num[i])){
                    int value = ht.get(num[i])+1;
                    ht.put(num[i],value);
                    //加完之后注意查看value是否>=n/2
                    if(value >= num.length/2){
                        System.out.println(num[i]);
                        flag = true;
                        break;
                    }
                }else{
                    ht.put(num[i],1);
                }
            }
           if(!flag){
               System.out.println("No");
           }

        }
    }
}
