package day11;

import java.util.Scanner;

/*
* 属于一个数字N,统计他每位数字出现的次数
* 比如说100311，2个0，3个1，1个3
* 输出按照D:M的格式，且要求按照D的升序输出*/
public class digitStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String n = sc.nextLine();
            int[] arr = new int[10];
            for (int i = 0; i < n.length(); i++) {
                int j = n.charAt(i)-'0';
                arr[j]++;
            }
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] != 0) {
                    System.out.println(j + ":" + arr[j]);
                }
            }
        }
    }
    //这种解法只能通过14.29%的用例，分析估计是因为数据类型给的不对
    //题中所写的是不超过1000位的正整数
    //int 和 long都不满足条件
    //所以将其转化为字符串
    //通过字符串的遍历来确定元素的个数
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            //用arr[10]来记录结果
            //其中i代表D（该为数字）
            //arr[i]代表数字D所出现的次数M
            int[] arr = new int[10];
            int i = 0;
            while(n != 0){
                i = n % 10;
                n /= 10;
                arr[i]++;
            }
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] != 0) {
                    System.out.println(j + ":" + arr[j]);
                }
            }
        }
    }

}
