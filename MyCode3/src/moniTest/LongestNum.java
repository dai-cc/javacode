package moniTest;

import java.util.Scanner;

/*
* 字符串中找出连续最长的数字串
* */
public class LongestNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            // 将字符串保存下来，然后遍历字符串
            int maxlen = 0;//之前遍历过的最长的数字长度
            String maxStr = "";
            int len = 0;//当前正在遍历的数字串长度
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)>='0' && s.charAt(i) <= '9'){
                    sb.append(s.charAt(i));
                    len++;
                    if(maxlen < len){
                        maxlen = len;
                        maxStr = sb.toString();
                    }
                }else{
                    len = 0;
                    sb = new StringBuilder("");
                }
            }
            System.out.println(maxStr);
        }

    }
}
