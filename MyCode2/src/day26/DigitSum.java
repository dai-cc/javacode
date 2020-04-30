package day26;

import java.util.Scanner;

/*
* 数字之和
* 对于给定的整数n，计算其十进制下所有位置数字和，以及其平方结果的各位数字之和
* 比如说：97
* 输出：16 22（97^2=9409 9+4+0+9=22）*/
public class DigitSum {
    private static int sum(int a){
        String s = a + "";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i)-'0';
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int a = sc.nextInt();

            int sum1 = sum(a);
            int sum2 = sum((int)Math.pow(a,2));
            System.out.println(sum1 + " " + sum2);
        }
    }
}
