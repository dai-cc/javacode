package day35;

import java.util.Scanner;

/*
* 风口得猪-中国牛市
* 已知一只股票连续n天的价格走势，一长度为n的整数数组表示
* 数组中第i个元素表十四该股票第i天的股价
* 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，
* 并且买入前一定要保证手上没有股票
* 若两次交易机会都放弃则收益为0
* 计算最大收益*/
public class ChineseBull {
    public int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;//第一次买入的价格，因为后续要比较哪次股价最低，所以先设置成最小值
        int firstSell = 0;

        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        //遍历数组找出获利最大的
        for (int i = 0; i < prices.length; i++) {
            // 因为要在最低价时买入，而买入又是支出，为负,
            // 所以比较哪一个支出最少
            firstBuy = Math.max(firstBuy,-prices[i]);
            //计算第一次出售获利最大的情况
            //firstBuy + prices[i]，由于firstBuy是负数，
            // 所以这两个相加是为当在股价为prices[i]时出售所获利
            firstSell = Math.max(firstSell , firstBuy + prices[i]);

            // 为了保证第二次时也是利益最大化
            // firstSell - prices[i] 第一次获益-当前股价最大时买入
            secondBuy = Math.max(secondBuy , firstSell - prices[i]);
            //secondBuy + prices[i]，由于firstBuy是负数，
            // 所以这两个相加是为当在股价为prices[i]时出售所获利
            secondSell = Math.max(secondSell , secondBuy + prices[i]);
        }
        //最后把结果返回
        return secondSell;
    }

}
