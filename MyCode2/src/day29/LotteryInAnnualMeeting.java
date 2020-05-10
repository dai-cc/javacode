package day29;

import java.util.Scanner;

/*
* 年会抽奖
* 抽奖规则：
*   1. 每个人都要写一张自己的名字放入抽奖箱
*   2. 名字加入完毕，每个人从箱中取出一张字条
*   3.  如果抽到的字条上是自己的名字，那就中奖了
* 告诉你参加晚会的人数，计算有多少概率会出现无人获奖？
* 每组测试用例包含一个正整数n(2<=n<=20)
* 以xx.xx%的格式输出发生无人获奖的概率
*/
public class LotteryInAnnualMeeting {
    private static float miscount(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return (n-1)*(miscount(n-1) + miscount(n-2));
    }
    private static float allcount(int n){
        int count = 1;
        for (int i = 1; i <= n; i++) {
            count *= i;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            //无人获奖的概率 = n个人都拿错的情况数/n个人拿出的所有排列情况数（n!）
            int n = sc.nextInt();
            //n个人都拿错的情况：(错排算法)
            //比如a没有拿到自己，其他n-1个人都有可能拿到，所以有n-1种情况
            //假设b被a拿到，那么对于其他n-2个人互相拿错又是一个子问题f(n-2)
            //假设b没有被a拿到，那么剩下的问题就是剩下的n-1个人互相拿错，也就是子问题f(n-1)
            //根据加法原理，完成第二部总共有f(n-2)+f(n-1)种情况
            //由此可根据乘法原理推出n种元素错排公式f(n)=(n-1)*(f(n-1)+f(n-2))
            float res = miscount(n)/allcount(n)*100;
            System.out.println(String.format("%.2f",res)+"%");
        }
    }
}
