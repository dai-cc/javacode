package com;

import java.util.Scanner;
/*给定回文串AB，将B插入A，返回能够使新字符串成为回文串的方法数*/
public class IsHuiWen {
    private static boolean isParilion(String str){
        int i = 0, j = str.length()-1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private static int numHuiWen(String A,String B){
        //先判断A有几个位置可以插入
        int count = A.length() + 1;
        for (int i = 0; i <= A.length(); i++) {
            String str1 = A.substring(0,i);
            String str2 = A.substring(i,A.length());
            String str = str1+B+str2;
            if(!isParilion(str)){
                count--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String A = in.next();
            String B = in.next();
            System.out.println(numHuiWen(A,B));
        }
    }
}
