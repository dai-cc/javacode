package com;

import java.util.Scanner;

public class demo0306 {
    //此处使用数组保存已经注册过的用户名字
    static String[] usernames = {"旺旺仙贝","旺旺雪饼"};
    public static void main(String[] args) {
        //仿照输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要注册的名字：");
        String name = scanner.next();
        checkUserName(name);
    }
    public static void checkUserName(String name){
        //遍历字符串数组，查看里面是否有该名字
        for (String uname:usernames) {
            //将已经存在的用户名和当前用户名比较
            if(name.equals(uname)){
                //用户名已经存在，抛出异常
               
            }
        }
    }
}
