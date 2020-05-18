package day36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class HexToDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //因为有可能有多组数据，所以实现将他们以0x为标志分开
            String[] s = sc.nextLine().split("0x");
            // new一个和s等长的int数组，用于存放转换了的数字
            int[] nums = new int[s.length];
            HashMap<String,Integer> hm = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                hm.put(Integer.toHexString(i),i);
            }
            for (int i = 0; i < s.length; i++) {
                //每一个十六进制数字用num表示
                if(!s[i].equals("")) {
                    String num = s[i].substring(0,s[i].length()-1).toLowerCase();
                    for (int j = num.length() - 1; j >= 0; j--) {
                        nums[i] += Math.pow(16, num.length() - 1 - j) * hm.get(num);
                    }
                    System.out.println(nums[i]);
                }
            }

        }
    }
}
