package com;

import java.util.Scanner;

public class Main {
    //末尾会出现0是因为遇到了2（或者倍数）和5
    //所以只需要计算有几个5就可以了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int count = 0;
            //可以等于0
            while(n > 0){

                n /= 5;
                count += n;
            }
            System.out.println(count);
        }
    }
}
