package day39;

import java.util.Scanner;

/*
* 回文串
* 给定一个字符串，问能否通过添加一个字母将其变为回文串
* 一行一个由小写字母构成的字符串，长度小于等于10
* 可以返回YES,不可以返回NO
* */
public class HuiWenChuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s1 = sc.nextLine();
            if(!s1.equals("")) {
                StringBuffer sb = new StringBuffer(s1);
                String s2 = sb.reverse().toString();

                int flg = 0;
                //fypypy  coco
                //ypypyf  ococ
                //两个字符串进行逐个遍历比较，如果s2.charAt(i)!=s1.charAt(j)那么j++,flg++
                //比较完之后判断flg大小
                //如果flg==1 YES，否则NO
                for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
                    if (s2.charAt(j) != s1.charAt(i)) {
                        j++;
                        flg++;
                    }
                }
                if (flg == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }else {
                System.out.println("NO");
            }
        }
    }
}
