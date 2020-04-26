package day23;

import java.util.Scanner;

/*
* 数字分类
* 给定一系列正整数，要求对数字进行分类，并输出以下5个数字：
*   A1 = 能被5整除的数字中所有偶数的和
*   A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...
*   A3 = 被5除后余2的数字的个数
*   A4 = 被5除后余3的数字的平均数
*   A5 = 被5除后余4的数字中的最大数字
* 每个输入包含1个测试用例，每个测试用例先给出一个不超过1000的正整数N，
* 随后给出N个待分类的正整数
* 若其中某一类数字不存在，则在相应位置输出N*/
public class DigitalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            int A1 = 0,A2 = 0,A3 = 0,A5 = 0;
            float A4 = 0;
            boolean f1 = false,f2 = false,f3 = false,f4 = false,f5 = false;
            int flg = 1;
            int count = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                if(arr[i] % 10 == 0){
                    //能被5整除的数字中所有偶数，也就是能被10整除的数
                    A1 += arr[i];
                    f1 = true;
                }
                if(arr[i] % 5 ==1){
                    //交错求和
                    A2 += (flg*arr[i]);
                    flg = -flg;
                    f2 =true;
                }
                if(arr[i] % 5 ==2){
                    A3++;
                    f3 = true;
                }
                if(arr[i] % 5 ==3){
                    A4 += arr[i];
                    count++;
                    f4 = true;
                }
                if(arr[i] % 5 ==4){
                    A5 = Math.max(A5,arr[i]);
                    f5 = true;
                }
            }
            if(f1){
                System.out.print(A1 + " ");
            }else{
                System.out.print("N ");
            }
            if(f2){
                System.out.print(A2 + " ");
            }else{
                System.out.print("N ");
            }
            if(f3){
                System.out.print(A3 + " ");
            }else{
                System.out.print("N ");
            }
            if(f4){
                System.out.printf("%.1f",A4/count);
                System.out.print(" ");
            }else{
                System.out.print("N ");
            }
            if(f5){
                System.out.print(A5 + " ");
            }else{
                System.out.print("N ");
            }
        }
    }
}
