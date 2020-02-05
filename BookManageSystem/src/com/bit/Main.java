package com.bit;

import com.bit.book.BookList;
import com.bit.user.Admin;
import com.bit.user.NormalUser;
import com.bit.user.User;

import java.util.Scanner;

public class Main{
    public static User login(){
        System.out.println("请输入您的名字：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("hello "+name+"! "+"请输入您的身份:");
        System.out.println("0.管理员  ,1.用户");
        Scanner scanner1=new Scanner(System.in);
        int sc=scanner1.nextInt();

        if(sc==0){
            Admin admin=new Admin(name);
            return admin;
        }
        NormalUser normalUser=new NormalUser(name);
        return normalUser;
    }
    public static void main(String[] args) {
        BookList bookList=new BookList();
        User user=login();
//        System.out.println(user.menu());

        while(true){
            int choice=user.menu();
            user.doOperation(choice,bookList);
        }
    }

}
