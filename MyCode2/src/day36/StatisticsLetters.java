package day36;

import java.util.LinkedHashMap;
import java.util.Scanner;

/*
*  字母统计
*   输入一行字幕，按A-Z的顺序输出其中大写字母出现的次数
* */
public class StatisticsLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            // 创建一个26位的数组，0代表A，25代表Z
            int[] a = new int[26];
            String  s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    a[s.charAt(i)-'A']++;
                }
            }
            for (int i = 0; i < 26; i++) {
                System.out.printf("%c:%d\n",('A'+i),a[i]);
            }

        }

    }
}
