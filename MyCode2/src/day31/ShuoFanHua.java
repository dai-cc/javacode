package day31;

import java.util.Scanner;

/*
* 说反话
* 把给出的话倒序输出
* Hello World Here I Come
* 输出：
* Come I Here World Hello
* */
public class ShuoFanHua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] s = sc.nextLine().split(" ");
            for (int i = s.length-1; i >=0 ; i--) {
                System.out.print(s[i]+" ");
            }
        }
    }
}
