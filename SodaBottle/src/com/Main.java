package com;

import java.util.Scanner;

/* 三个空汽水瓶可以换一瓶水，有n个空汽水瓶可以换多少瓶汽水
* */
public class Main {
    public static int sodaBottle(int n){
        //判断所给的n的大小，=1返回0，=3返回1，=2返回2（问老板借一瓶满的，喝完凑三个瓶子再换一瓶）
        int num = 0;//能喝到的汽水数
        while (n > 2) {
            num += n/3;
            n = n / 3 + n % 3;
        }
        if(n == 2 ){
            //此时可以再借一瓶
            num += 1;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if(n==0){
                break;
            }
            System.out.println(sodaBottle(n));
        }
    }
}
