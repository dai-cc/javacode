package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //最小公倍数 = ab/ab最大公约数
            //所以应该先求最大公约数
            //先让a,b比较大小，保证a>b
            //num=a%b,a = b,b=num
            if(a==b || a%b ==0 || b%a==0){
                int num = a>=b?a:b;
                System.out.println(num);
            }
            int result = a*b;
            if(a<b){
                int temp = a;
                a = b;
                b = temp;
            }
            while(b != 0){
                int temp = a%b;
                a = b;
                b = temp;
            }
            System.out.println(result/a);
        }
    }
}
