package day27;

import java.util.Scanner;

/*
* 将IP地址和整数之间相互转换
* IP地址的每段可以看成是0——255的整数
* 把每段拆分成一个二进制形式组合起来，
* 然后把二进制数转变为一个长整数
* 10.0.3.193
* --》00001010 00000000 00000011 11000001
* --》167773121
*
* 现输入IP地址，在输入10进制10地址
* 输出两个分别转换的结果*/
public class IntExchangeIP {
    private static void ipToDec(String a){
        String[] strs = a.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            //得到每一段十进制Ip的二进制序列
            String s = Integer.toBinaryString(Integer.parseInt(strs[i]));

            //有可能得到的二进制序列不够8位，将他补全
            if(8 > s.length()){
                int k = 8-s.length();
                StringBuffer temp = new StringBuffer();
                while(k > 0){
                    temp.append("0");
                    k--;
                }
                s = temp.toString() + s;
            }
            //将补全的二进制序列添加到sb中
            sb.append(s);
        }
        long ipToDec = Long.parseLong(sb.toString(),2);
        System.out.println(ipToDec);
    }
    public static void decToIP(String b){
        //首先要把十进制序列转变成二进制序列
        String s = Long.toBinaryString(Long.parseLong(b));
        //每八位一分进行计算
        //要注意s可能没有32位，所以要先在前面补0，保证s够32位
        if(32 > s.length()){
            int k = 32 - s.length();
            StringBuffer temp = new StringBuffer();
            while(k > 0){
                temp.append("0");
                k--;
            }
            s = temp.toString() + s;
        }
        String s1 = s.substring(0,8);
        String s2 = s.substring(8,16);
        String s3 = s.substring(16,24);
        String s4 = s.substring(24,32);
        System.out.println(Integer.parseInt(s1,2)+"."+Integer.parseInt(s2,2)
                +"."+Integer.parseInt(s3,2)+"."+Integer.parseInt(s4,2));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.next();
            String b = sc.next();
           ipToDec(a);
           decToIP(b);
        }
    }
}
