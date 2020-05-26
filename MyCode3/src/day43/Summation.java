package day43;

import java.util.HashSet;
import java.util.Scanner;

/*
* 求和
* 输入两个整数n和m，从数列1，2，3，。。。n中随意取几个数，使其和等于m，
* 要求将其中所有的可能组合列出来
*
* 每个测试用例输入包含两个整数n和m
* 按每个组合的字典序排列输出，每行输出一种组合
* */
public class Summation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();

            // 先要判断n和m的大小关系
            int min = Math.min(n, m);
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 1; i <= min; i++) {
                StringBuffer sb = new StringBuffer();
                if(m - i <= n){
                    // 如果和他配对的和为m的数字再n的范围内，那这一对可以打印
                    sb.append(i);
                    sb.append(" ");
                    sb.append(m-i);
                    if(i != m-i && m-i != 0 && !hs.contains(i) && !hs.contains(m-i)){
                        hs.add(i);
                        hs.add(m-i);
                        System.out.println(sb.toString());
                    }
                }
            }
            if(min == m){
                System.out.println(m);
            }
/*            int len = 0;
            if(m%2 == 0){
                len = m/2 - 1;
            }else{
                len = m/2;
            }

            for (int i = 0; i < len; i++) {
                StringBuffer sb = new StringBuffer();
                sb.append(i+1);
                sb.append(" ");
                sb.append(m-i-1);
                System.out.println(sb.toString());
            }*/
            //System.out.println(m);
        }
    }
}
