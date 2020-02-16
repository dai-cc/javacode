package com.dai;

import java.util.ArrayList;
import java.util.List;

/*斗地主综合案例：有序版本
* 1.准备牌
*      两张特殊牌：大王小王
 *      52张牌：创建两个LIST集合一个存放花色，一个存放牌数值
 *      用map集合存放准备好的牌 key值放牌的索引，value放准备好的牌
 *2.洗牌：
 *      准备一个List集合存放牌的索引，调用Collections.sheffle方法将索引打乱完成洗牌
 *3.发牌：
 *      一人一张轮流发牌，发给三个人，一人17张，剩余三张作为底牌
 *4.排序：
 *      用Collections中的Sort方法将每人的牌排好序
 *5.看牌：
 *      通过玩家和底牌的List集合可以获取到Map中的key值，通过key 值找value
*/
public class douDiZhu {
    public static void main(String[] args) {

    }
}
