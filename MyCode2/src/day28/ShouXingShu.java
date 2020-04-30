package day28;

import java.util.Scanner;

/*
* 判断N是否为守形数
* 守形数是指平方的低位部分等于它本身
* 比如25的平方是625，因此25是守形数
* 如果是守形数则输出Yes!，否则输出No!
* */
public class ShouXingShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String N = sc.next();//25
            int num = (int)Math.pow(Integer.parseInt(N),2);//625
            String str1 = num + "";//625
            String s = str1.substring(str1.length()-N.length());
            if(s.equals(N)){
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }
}
