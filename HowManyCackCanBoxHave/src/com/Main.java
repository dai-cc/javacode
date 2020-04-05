package com;

/*
*   一个网格盒子长宽分别为W,H，每个格子可以放至多一个弹道
*   任意两块蛋糕的欧几里得距离不能等于2
*   欧几里得距离=（（x1-x2）*(x1-x2)+(y1-y2)*(y1-y2))的算数平方根
*   欧几里得距离就是直角坐标系两点之间的距离
*   说明任意两块蛋糕之间的距离不能=2
*   */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int W = sc.nextInt();//网格的长
            int H = sc.nextInt();//网格的宽
            //分割出来的格子相当于一个int[W][H]的二维数组
            //先将创建一个全0的数组，开始遍历，
            // 每遍历一个就将这个位置（i,j）置为1，并且将（i+2,j）(i,j+2)置为-1
            //置为1前判断这个位置是否为0，为0则将其置为1，count++,为-1则遍历下一个
            int[][] arr = new int[W][H];
            int count = 0;
            for (int i = 0; i < W; i++) {
                for (int j = 0; j < H; j++) {
                    if(arr[i][j]==0){
                        count++;
                        arr[i][j] = 1;
                        if(i + 2 < W)
                            arr[i+2][j] = -1;
                        if(j + 2 < H)
                            arr[i][j+2] = -1;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
