package day41;

import java.util.Scanner;

/*
* 连续最大和
* 一个数组有N个元素，求连续子数组最大和
* 输入两行，第一行n表示有n个元素，第二行n个数
* 求所有连续子数组中和最大的值
* */
public class SerialMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if(sum > max){
                    max = sum;
                }
                if(sum <= 0){
                    sum = 0;
                }
            }
            System.out.println(max);
        }
    }
}
