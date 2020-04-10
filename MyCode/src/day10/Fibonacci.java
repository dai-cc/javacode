package day10;

import java.util.Scanner;

/*给定一个数，输出最小的将其变为斐波那契数的步数
* 比如说斐波那契数列：0，1，1，2，3，5，8，13...
* 输入N为15，最少2步就可将其变为斐波那契数，N减两次1*/
public class Fibonacci {
    public static int fib(int N){
        int fib1 = 0;
        int fib2 = 1;
        int fib3 ;
        while(true){
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
            //一旦找到一个比N大的斐波那契数，那就标记该数和上一个数
            //由于此时上一个数已经赋给了fib1
            //所以标记fib1和fib3或fib2
            if(fib3 >= N){
                break;
            }
        }
        fib1 = Math.abs(fib1-N);
        fib2 = Math.abs(fib2-N);
        return fib1<fib2?fib1:fib2;
    }
    public static void main(String[] args) {
        /*实际上就是要求给定的N和离他最近的斐波那契数的差值*/
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            System.out.println(fib(N));
        }
    }
}
