package day34;

import java.util.HashSet;
import java.util.Scanner;

/*
* Broken Keyboard
* 给出原本想要输出的字符串和实际输出的字符串，求哪些键是坏掉的
* 不分大小写，坏键全部用大写表示
* 输入：
*   7_This_is_a_test
*   _hs_s_a_es
* 输出：
*   7TI
* */
public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            // 创建一个hashset,往里面添加想要输入的每一个字符
            // 然后接受实际输出的字符串，逐字符检验是否包含在hashset中，包含则说明该键没坏，不包含说明键坏了
            String str1 = sc.nextLine().toUpperCase();
            String str2 = sc.nextLine().toUpperCase();
            HashSet<Character> hs = new HashSet<>();
            StringBuffer sb = new StringBuffer();

/*          没有按输入的顺序输出坏键，所以没通过
            for (int i = 0; i < str1.length(); i++) {
                hs.add(str1.charAt(i));
            }
            for (int i = 0; i < str2.length(); i++) {
                if(hs.contains(str2.charAt(i))){
                    hs.remove(str2.charAt(i));
                }
            }
            for (char x:hs) {
                System.out.print(x);
            }*/
            for (int i = 0; i < str2.length(); i++) {
                hs.add(str2.charAt(i));
            }
            HashSet<Character> hs1 = new HashSet<>();
            for (int i = 0; i < str1.length(); i++) {
                if(!hs.contains(str1.charAt(i)) && !hs1.contains(str1.charAt(i))){
                    sb.append(str1.charAt(i));
                    hs1.add(str1.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
