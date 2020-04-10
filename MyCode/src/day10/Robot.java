package day10;
/*
* XY的网格，一个机器人只能走格点且只能向右或向下走，
* 要从左上角走到右下角
* 设计一个算法，计算机器人有多少种走法
* 给定两个正整数x,y
* 返回机器人的走法数目
* 保证x+y<=12*/
public class Robot {
    // 可以用递归的方式去做
    // 当x=1或y=1时只有一种走法
    // 其他情况下，比如说一个2*2的
    // 向右走一格之后的走法和1*2的走法一样
    // 向下走一格之后的走法和2*1的走法一样
    // 以此类推
    public static int countWays(int x, int y) {
        if(x == 1 ||y == 1){
            //此时只有1中走法，返回1
            return 1;
        }
        return countWays(x-1,y)+countWays(x,y-1);
    }

    public static void main(String[] args) {
        System.out.println(countWays(2,2));
    }
}
