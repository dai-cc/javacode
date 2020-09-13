package Didi;

import java.io.IOException;
import java.util.Scanner;

/*
* X星人最近流行打暗语，大家都喜欢把信息加密后再发送给对方，然后再偷偷告诉人家破解方法，他们觉得这样很酷。
某X星人发明了一种加密方法，该加密方法是将一个明文字符串从左到右分割成若干个长度相等的子字符串（最后一个子字符串的长度可以不同），然后将每个子字符串中的字符进行逆序，从而得到密文。
但是，X星人可不会轻易告诉你每个子字符串的长度是多少。还好你够聪明，每次都能够猜到X星人设置的长度值。
现在你成功截取了X星人的密文并且也猜到了X星人设置的长度值，能否写一个程序将该密文破解得到对应的明文呢？

* */
public class Solution1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();// 标识分割的子字符串长度
        String s = sc.nextLine();
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();// 标识密文字符串*/

        StringBuilder sb = new StringBuilder();
        int f = s.length() % n;
        // 如果能够整除
        for (int i = 0; i < s.length() - f; i += n) {
            for (int j = i + n - 1; j >= i; j--) {
                sb.append(s.charAt(j));
            }
        }
        // 如果不能整除的话，处理剩下的
        for (int i = s.length() - 1; i >= s.length() - f; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }
}

