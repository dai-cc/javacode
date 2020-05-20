package day37;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 木棒拼图
* 有一个有很多木棒构成的集合，每个木棒有对应的长度，
* 能否用集合中的这些木棒以某个顺序首尾相连构成面积大于0的简单多边形
* 且所有木棒都要用上
*
* 初始集合为空，有两种操作，要么给集合添加一个长度为L的木棒，要么删去集合中已有的某个木棒
* 每次操作结束后都需要告知是否能用集合中的这些木棒构成一个简单的多边形
*
* 每组数据第一行是一个正整数n表示操作的数量，接下来有n行，每行第一个整数微操作的类型i
* 第二个整数为长度l
* 如果i=1表示插入L，i=2表示删去集合内一根长度为l的木棒
* 输入数据保证删除时集合中必定存在长度为L的木棒，且任意操作都是非空集合
*
* ????????没通过，检查数组越界*/
public class StickThePuzzle {
    //判断是否能构成多边形
    // 要在木棍集合中找出一根最长的记为maxlen,其他记为otherlen，
    // 如果otherlen>maxlen,那么就可以构成多边形
    // 也可以说总长度len-maxlen > maxlen ，可以构成多边形
    private static void success(long len,long maxlen){
        if(len - maxlen > maxlen){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();//操作次数
            // 用Integer会报数组越界异常
            List<Long> l = new ArrayList<>();
            long maxlen = 0;
            long len = 0;
            while(n-- > 0){
                long i = sc.nextLong();
                long L = sc.nextLong();
                if(i == 1){
                    l.add(L);
                    // 插入操作，判断当前插入L是否为最大，如果是最大就用max标记
                    if(L > maxlen){
                        maxlen = L;
                    }
                    len += L;
                    success(len,maxlen);
                }else if(i == 2){
                    l.remove(L);
                    len -= L;
                    if(maxlen==L){
                        for (long x:l) {
                            if(maxlen < x){
                                x = maxlen;
                            }
                        }
                    }
                    success(len,maxlen);
                }

            }
        }
    }
}
