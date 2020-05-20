package day37;

import java.util.Scanner;

/*
* 地下迷宫
* n*m迷宫，迷宫每个位置为0或1，为0表示有障碍物，到达不了，1代表可以到达
* 小青蛙初始在0，0,地下迷宫在0,m-1
* 青蛙水平移动需要耗费1点体力值，向上需要耗费3点体力值，向下不耗费体力值
* 当体力值为0还没有到达出口，青蛙将无法逃离迷宫，
* 输入n+1行：第一行为3个整数n,m,p（体力值）
*           接下来n行，每行m个0或1，以空格分离
* 如果能逃离迷宫则输出一行体力消耗最小的路径，不能输出Can not escape!*/
public class UndergroundMiGong {
    //逃离迷宫的路
    static String Path = "";
    private static String way(int n,int m ,int p ,int[][] migong){
        if(n <= 0){
            return "Can not escape!";
        }
        boolean[][] visited = new boolean[n][m];
        findPath(n,m,migong,0,0,"",visited,p);
        return Path;
    }
    private static void findPath(int n,int m,int[][] migong,int nowx,int nowy,String res,boolean[][] visited,int p){
        if(nowx == 0 && nowy == m-1 && migong[0][m-1] == 1){
            if(p >= 0){
                Path = res + "[0," + (m-1) + "]";
            }else {
                Path = "Can not escape!";
            }
            return;
        }
        if(nowx < n && nowy < m && nowx >= 0 &&nowy >=0 && migong[nowx][nowy] ==1 && !visited[nowx][nowy]){
            visited[nowx][nowy] = true;
            res += "[" + nowx + "," + nowy + "],";
            //水平向右
            findPath(n,m,migong,nowx,nowy+1,res,visited,p -1);

            //水平向左
            findPath(n,m,migong,nowx,nowy-1,res,visited,p -1);

            //向上
            findPath(n,m,migong,nowx -1,nowy,res,visited,p -3);

            //向下
            findPath(n,m,migong,nowx+1,nowy+1,res,visited,p);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int[][] migong = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    migong[i][j] = sc.nextInt();
                }
            }
        }
    }
}
