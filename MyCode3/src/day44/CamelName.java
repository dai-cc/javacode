package day44;

import java.util.Scanner;

/*
* 驼峰命名法
* 将用下划线命名的字符串改成驼峰命名法*/
public class CamelName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            String[] strings = s.split("_");
            for (int i = 1; i < strings.length; i++) {
                strings[i] = strings[i].substring(0,1).toUpperCase() + strings[i].substring(1);
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strings.length; i++) {
                sb.append(strings[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
