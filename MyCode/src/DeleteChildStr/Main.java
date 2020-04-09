package DeleteChildStr;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static String deleteChildStr(String str1,String str2){
        //将字符串2存放在hashmap里面，然后将str1分别往进放，
        // 如果成功了那就说明不重复，失败了就说明重复了，把当前字符删掉
        StringBuffer sb = new StringBuffer();
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            hm.put(str2.charAt(i),i);
        }
        for (int i = 0; i < str1.length(); i++) {
            if(!hm.containsKey(str1.charAt(i))){
                //不包含则说明里面没有这个元素
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(deleteChildStr(str1,str2));
        }
    }
}
