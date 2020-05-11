package day30;

import java.util.Scanner;

/*
* 奇偶校验
* 输入一个字符串，对每个字符串进行奇校验，最后输出校验后的二进制*/
public class OddEvenCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //题中统一将数字和字母看成char类型
            //所以实际3存储时是ASC码，十进制51，转二进制是0110011，
            // 取最高位为奇校验位，校验位为1，所以10110011
            String s = sc.next();
            for (int i = 0; i < s.length(); i++) {
                String a = Integer.toBinaryString(s.charAt(i));
                StringBuffer sb = new StringBuffer();
                int count = a.length();
                if(count < 7){
                    sb.append(0);
                    count++;
                }
                a = sb.append(a).toString();
                int num = 0;
                for (int j = 0; j < a.length(); j++) {
                    if(a.charAt(j) == '1'){
                        num++;
                    }
                }
                if(num % 2==0){
                    a = 1 + a;
                }else {
                    a = 0 + a;
                }
                System.out.println(a);
            }
        }
    }
}
