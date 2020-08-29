package MeiTuan;

import java.util.Scanner;

/*
* 小美的一个兼职是美团的一名跑腿代购员，她有n个订单可以接，订单编号是1~n，但是因为订单的时效性，
* 他只能选择其中m个订单接取，精明的小美当然希望自己总的获利是最大的，
* 已知，一份订单会提供以下信息，跑腿价格v，商品重量w kg，
* 商品每重1kg，代购费用要加2元，而一份订单可以赚到的钱是跑腿价格和重量加价之和。
* 小美可是开兰博基尼送货的人，所以自然不会在意自己会累这种事情。
* 请问小美应该选择哪些订单，使得自己获得的钱最多。

请你按照选择的订单编号的从小到大顺序，如果存在多种方案，输出订单编号字典序较小的方案。*/
public class runner {
    private static int moneyMax(int m, int n, int[] weight, int[] value){
        int[] dp = new int[m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = m; j >= weight[i-1]; j--) {
                dp[j] = Math.max(dp[j-weight[i-1]+value[i-1]],dp[j]);
            }
        }
        return dp[m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();// 所有的订单数量
            int m = sc.nextInt();// 小美可以接受的订单数量
            int[] weight = new int[n];
            int[] value = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
                value[i] = sc.nextInt();
            }
            System.out.println(moneyMax(m,n,weight,value));
        }
    }
}
