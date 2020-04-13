package day13;

import java.util.Scanner;
/*
* 输出一个正方形，给定正方形的边长N，和组成正方形边的字符c，中间间隔一个空格
* 输出由字符c化成的正方形，要求：输出的行数是列数的1/2*/
public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();//边长
            String ch = sc.next();

            for (int i = 0; i < N; i++) {
                System.out.print(ch);
            }
            System.out.println();
            //注意此处要求行四舍五入
           //用向上取整
            float a = N;
            for (int i = 0; i < Math.ceil(a/2)-2 ; i++) {
                System.out.print(ch);
                for (int j = 0; j < N-2; j++) {
                    System.out.print(" ");
                }
                System.out.println(ch);
            }
            for (int i = 0; i < N; i++) {
                System.out.print(ch);
            }
        }
    }
}
