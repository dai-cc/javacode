
package day41;

/*
*  在java中，时常会用到查看一个字符串是否是数字，这时就可以用到matches()函数。
具体实例如下：
public boolean string_matches(String amatch)
{
If (amtch.matches("//g++"))
   return ture;
}
"//g++"是参数，专门用来查看字符串是否是数字。
总结：自己在使用当中一直把matches写成match，导致编译时找不到函数名，这是我的错误一。错误二在于我把"//"写成了"\\"，这样会导致在运行时出现异常，但编译时不会出现错误。*/
/*
import java.util.Scanner;

*/
/*
* 坐标移动
* 从（0，0）开始，A向左，D向右，W向上，S向下
* 从输入字符串读取坐标
* 输出最终坐标
* *//*

public class CoordinateMove {
    private static int coordinate(String s){
        s = s.substring(1,s.length());
        int x = Integer.parseInt(s);
        return x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] coor = s.split(";");
            int x = 0;
            int y = 0;
            for (int i = 0; i < coor.length; i++) {
                if(coor[i].charAt(0) == 'A'){
                    x -= coordinate(coor[i]);
                }
                if(coor[i].charAt(0) == 'D'){
                    x += coordinate(coor[i]);
                }
                if(coor[i].charAt(0) == 'W'){
                    y += coordinate(coor[i]);
                }
                if(coor[i].charAt(0) == 'S'){
                    y -= coordinate(coor[i]);
                }
            }
            System.out.println(x+","+y);
        }
    }
}
*/


import java.util.Scanner;

public class CoordinateMove {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.nextLine();

            String[] str = s.split(";");

            int row = 0;
            int column = 0;

            for (int i = 0; i < str.length; i++) {
                if (str[i].length() <= 3) {
                    if (str[i].charAt(0) == 'A' && str[i].substring(1).matches("[0-9]+")) {
                        row -= Integer.parseInt(str[i].substring(1));
                    }

                    if (str[i].charAt(0) == 'D' && str[i].substring(1).matches("[0-9]+")) {
                        row += Integer.parseInt(str[i].substring(1));
                    }

                    if (str[i].charAt(0) == 'W' && str[i].substring(1).matches("[0-9]+")) {
                        column += Integer.parseInt(str[i].substring(1));
                    }

                    if (str[i].charAt(0) == 'S' && str[i].substring(1).matches("[0-9]+")) {
                        column -= Integer.parseInt(str[i].substring(1));
                    }
                }
            }

            System.out.println(row + "," + column);
        }

    }
}