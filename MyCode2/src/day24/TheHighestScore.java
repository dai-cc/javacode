package day24;

import java.util.Scanner;

/*
* 第一行是两个正整数N(学生数目)和M（操作数目）
* 学生的ID从1~N
* 第二行包含N个整数，代表N个学生初始成绩，其中第i个数表示ID为i的学生的成绩
* 接下来又M行，每一行有一个字符C（C只取Q,U）和两个正整数A,B
* Q表示询问操作，询问ID从A 到B (包括AB)的学生当中，成绩最高的是多少
* U表示更新操作，要求把ID为A的学生成绩更改为B
* 对于每一次询问操作，输出最高成绩*/
public class TheHighestScore {
    private static void question(int[] arr,int A,int B){
        //注意这个地方要考虑到A,B的大小关系
        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }
        int max = 0;
        for (int i = A-1; i < B ; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    private static void update(int[] arr,int A,int B){
        arr[A-1] = B;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();//学生数目
            int M = sc.nextInt();//操作次数
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            while(M > 0 && sc.hasNext()){
                String s = sc.next();
                int A = sc.nextInt();
                int B = sc.nextInt();
                if("Q".equals(s)){
                    question(arr,A,B);
                }
                if("U".equals(s)){
                    update(arr,A,B);
                }
                M--;
            }
        }
    }
}
