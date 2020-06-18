package web2;

import java.util.Arrays;
import java.util.*;
public class Restaurant {


// 输入第一行两个整数:n张桌子 m批客人   3 5
// 第二行n个参数a，即每个桌子可容纳的最大人数，以空格分割，范围均在32位int范围内。2 4 2
// 接下来m行，每行两个参数第i批客人的人数b,和预计消费金额c  1 3   3 5   3 7   5 9   1 10
// 输出一个整数，表示最大的总预计消费金额

    public static void main(String[] args){
        // 能容纳的下的所有订单中钱最多的
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] maxPeople = new int[n];
            int[][] bc = new int[m][2];
            for(int i = 0; i < n; i++){
                maxPeople[i] = sc.nextInt();
            }
            for(int j = 0; j < m; j++){
                bc[j][0] = sc.nextInt();
                bc[j][1] = sc.nextInt();
            }
            // b[0][0] b[0][1]
            // 1 3   3 5   3 7   5 9   1 10
            // 给最大容纳人数排序
            Arrays.sort(maxPeople);
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    int max = 0;
                    if(maxPeople[i] > bc[j][0]){
                        if(max < bc[j][1]){}
                        max = bc[j][1];
                    }
                    count += max;
                }
            }
            System.out.println(count);
        }
    }
}