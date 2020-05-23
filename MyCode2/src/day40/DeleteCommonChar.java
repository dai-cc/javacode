package day40;

import java.util.HashSet;
import java.util.Scanner;

/*
* 删除公共字符
* 输入两个字符串，从第一个字符串中删除第二个字符串中的所有字符
* */
public class DeleteCommonChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < s2.length(); i++) {
                hs.add(s2.charAt(i));
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s1.length(); i++) {
                if(!hs.contains(s1.charAt(i))){
                    sb.append(s1.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
