package com.dai;

import java.util.ArrayList;
import java.util.Random;

public class Demo2 {
    public void getSmallList(ArrayList<Integer> list){
        ArrayList<Integer> smallList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%2==0){
                smallList.add(list.get(i));
            }
        }
        System.out.println(smallList);
    }
    public static void main(String[] args) {
        Demo2 demo2=new Demo2();
        ArrayList<Integer> bigList=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i < 20; i++) {
            bigList.add(random.nextInt(100)+1);
        }
        System.out.println(bigList);
        demo2.getSmallList(bigList);
    }
}
