package day42;

import java.util.Scanner;

/*
* 字符串加解密
* 对输入的字符串进行加解密并输出
* 加密：当内容是英文字母则用该字母的下一个字母替换，同时转变字母大小写
*       当内容是数字时，数字+1，注意9变0 其他不变
* 解密：加密的逆过程
* */
public class StringCodeDecode {
    // 加密
    private static String Encrypt(String s){
        StringBuffer sb = new StringBuffer();
        int[] num = {1,2,3,4,5,6,7,8,9,0};
        String a = "bcdefghijklmnopqrstuvwxyza";
        String b = a.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(num[s.charAt(i)-'0']);
            }else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(b.charAt(s.charAt(i)-'a'));
            }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append(a.charAt(s.charAt(i)-'A'));
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    // 解密
    private static String unEncrypt(String s){
        StringBuffer sb = new StringBuffer();
        int[] num = {9,0,1,2,3,4,5,6,7,8};
        String a = "zabcdefghijklmnopqrstuvwxy";
        String b = a.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(num[s.charAt(i)-'0']);
            }else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(b.charAt(s.charAt(i)-'a'));
            }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append(a.charAt(s.charAt(i)-'A'));
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(Encrypt(s1));
            System.out.println(unEncrypt(s2));
        }
    }
}
