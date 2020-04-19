package day18;

import java.util.Scanner;

/*
* 输入原始字符串和所要找的子串长度
* 在一段字符串中找出含GC比例最高的子串并输出
* */
public class DNA_GC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            int len = sc.nextInt();
            int count = 0;
            int begin = 0;
            for (int i = 0; i < len; i++) {
                if(str.charAt(i) == 'C'|| str.charAt(i) == 'G'){
                    count++;
                }
            }
            int n = count;
            for (int i = 1; i <= str.length()-len; i++) {
                if(str.charAt(i-1) == 'C'|| str.charAt(i-1) == 'G'){
                    n--;
                }
                if(str.charAt(i+len-1) == 'C'|| str.charAt(i+len-1) == 'G'){
                    n++;
                }
                if(n > count){
                    count = n;
                    begin = i;
                }
            }
            System.out.println(str.substring(begin,begin+len));
        }
    }
}
