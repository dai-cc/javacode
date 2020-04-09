package BuyApple;

import java.util.Scanner;

public class Main2 {
    private static int buyApple(int n){
        int num = 0;
        //如果是奇数个一定买不到
        if(n % 2 != 0 || n < 6){
            return -1;
        }
        //尝试可不可以被整除，如果可以的话，就直接返回n/6或者n/8
        //如果不能被整除的话，查看/6的余数是否能被8整除，
        // 不可以的话再看/8的余数是否能被6整除
        while(n >= 6){
            if(n % 8 == 0){
                num += n/8;
                n = 0;
                break;
            }else{
                n -= 6;
                num++;
            }
        }
        //如果跳出循环只有两种情况 :1. 能刚好买到，2. 被减到0<n<6了
        return n==0?num:-1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(buyApple(n));
        }

    }
}
