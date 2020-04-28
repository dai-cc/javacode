package day25;

import java.util.Scanner;

/*
* 求学分绩点
* 1. 一门课程的学分绩点 = 该课绩点 * 该课学分
* 2. 总评绩点 = 所有学科绩点之和/所有课程学分之和
* 实际成绩90~100 85~89 82~84 78~81 75~77 72~74 68~71 64~67 60~63 60以下
* 对应绩点 4.0    3.7   3.3   3.0   2.7   2.3   2.0   1.5   1.0   0
*
* 输入描述：第一行:总的课程数n   第二行：相应课程的学分  第三行：对应课程的实际得分
* 输出：输出有一行，总评绩点，精确到小数点后2位小数*/
public class GPA {
    //获取每一门科目的绩点
    private static double getG(int score){
        double G = 0;
        if(score >= 90 &&score <= 100){
            G = 4.0;
        }else if(score >= 85 &&score <= 89){
            G = 3.7;
        }else if(score >= 82 &&score <= 84){
            G = 3.3;
        }else if(score >= 78 &&score <= 81){
            G = 3.0;
        }else if(score >= 75 &&score <= 77){
            G = 2.7;
        }else if(score >= 72 &&score <= 74){
            G = 2.3;
        }else if(score >= 68 &&score <= 71){
            G = 2.0;
        }else if(score >= 64 &&score <= 67){
            G = 1.5;
        }else if(score >= 60 &&score <= 63){
            G = 1.0;
        }else {
            G = 0;
        }
        return G;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] credit = new int[n];
            int creSum = 0;
            for (int i = 0; i < n; i++) {
                credit[i] = sc.nextInt();
                creSum += credit[i];
            }
            double[] G = new double[n];
            double Gsum = 0;
            for (int i = 0; i < n; i++) {
                G[i] = getG(sc.nextInt()) * credit[i];
                Gsum += G[i];
            }
            double GPA = Gsum/creSum;
            System.out.printf("%.2f",GPA);
        }
    }
}
