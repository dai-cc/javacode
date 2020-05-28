package day45;

import java.util.HashMap;
import java.util.Scanner;

/*
* 乒乓球框
* 两盒乒乓球，需要判断A中是否包含了B中所有的种类，并且每种球的数量不少于B盒中的数量
* 输入两个字符串AB，代表AB中的乒乓球，每个乒乓球用一个大写字母标识，
* 即相同类型的乒乓球为相同的大写字母
* 如果B中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出Yes，否则输出No
* */
public class PingPongBasket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String A = sc.next();
            String B = sc.next();
            HashMap<Character,Integer> hm = new HashMap<>();
            for (int i = 0; i < A.length(); i++) {
                hm.put(A.charAt(i),hm.getOrDefault(A.charAt(i),0)+1);
            }
            boolean flg = true;
            for (int i = 0; i < B.length(); i++) {
                int val = hm.getOrDefault(B.charAt(i),0);
                if(val > 0){
                    hm.put(B.charAt(i),val-1);
                }else{
                    flg = false;
                }
            }
            if(flg){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
