package day21;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/*
* 输入密文，输出解密后的明文
* 密文是明文中的字母之后的第五个字母替换
* 密文仅有空格和大写字母组成
* */
public class DeCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' '){
                    sb.append(" ");
                }else {
                    char temp = str.charAt(i) ;
                    if(temp >= 'A' && temp <= 'E'){
                        temp += 21;
                    }else{
                        temp -= 5;
                    }
                    sb.append(temp);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
