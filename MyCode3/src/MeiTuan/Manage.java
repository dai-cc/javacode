package MeiTuan;

import java.util.Scanner;

/*
*  小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，
* 每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。
* 已知货物入库的时候是按顺序堆放在一起的。
* 如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，
* 这样可以保证货物局部的顺序不变。
* 已知货物最初是按1~n的顺序堆放的，
* 每件货物的重量为w_i,小美会根据单据依次不放回的取出货物。
* 请问根据上述操作，小美每取出一件货物之后，重量和最大的一堆货物重量是多少？
输入第一行包含一个正整数n，表示货物的数量。(1<=n,m<=50000)
输入第二行包含n个正整数，表示1~n号货物的重量w_i。(1<=w_i<=100)
输入第三行有n个数，表示小美按顺序取出的货物的编号，也就是一个1~n的全排列
*/
public class Manage {
    private static int sum(int[] arr,int x,int y){
        int sum = 0;
        for (int i = x; i < y; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] w = new int[n];// 物品的重量
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }
            int[] bianhao = new int[n];//取出物品的顺序
            for (int i = 0; i < n; i++) {
                bianhao[i] = sc.nextInt();
            }
            // 依次按顺序取出物品并计算两边的大小
            int left = 0;
            int right = 0;
            for (int i = 0; i < n; i++) {
                int x = bianhao[i]; // 要取出的第i个物品对应在重量数组中的编号
                w[x-1] = 0;
                left = sum(w,0,x-1);
                right = sum(w,x+1,n);
                int max = Math.max(left,right);
                System.out.println(max);
            }
        }
    }
}
