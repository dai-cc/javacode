package lesson1;

import java.util.Scanner;

public class ScannerTest {
    /*
    * 现输入一行数字 代表要输入的元素的个数
    * 在输入一行数字 输入n个数字*/
    public static void main(String[] args) {
        //输入十个测试用例
        for (int i = 0; i < 10; i++) {
            Scanner sc = new Scanner(System.in);
            //注意sc.hasNext...这些方法都是阻塞时方法，
            // 造成当前线程阻塞，满足一定条件才返回
            //多线程的阻塞也是需要满足一定条件才返回：synchronized,join,sleep,wait
            //hasNext满足换行符（如果后面有sc.next 遇到输入空格或回车时返回空格/回车之前的东西）等特殊字符式返回，读取到之后返回符号之前的所有内容
            //hasNextLint 满足换行符
            //hasNextInt 直到读取到不满足int类型的字符时
        }
    }
}
