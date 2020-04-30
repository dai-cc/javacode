package day28;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 密码验证合格程序
 * 密码要求:
 * 1. 长度超过8位
 * 2. 包括大小写字母，数字，其他符号，以上四种至少三种
 * 3. 不能有相同长度超2的子串重复(长度超过2的子串)
 * 如果符合输出OK，否则输出NG
 * */
public class PasswordCheckOk {
    private static boolean lenthOK(String str) {
        if (str.equals(null) || str.length() <= 8) {
            return false;
        }
        return true;
    }

    private static boolean charnumOK(String str) {
        int n = 0;
        boolean flg1 = false, flg2 = false, flg3 = false, flg4 = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)) && !flg1) {
                n++;
                flg1 = true;
            } else if (Character.isLowerCase(str.charAt(i)) && !flg2) {
                n++;
                flg2 = true;
            } else if (Character.isDigit(str.charAt(i)) && !flg3) {
                n++;
                flg3 = true;
            } else if (!flg4
                    && !Character.isUpperCase(str.charAt(i))
                    && !Character.isLowerCase(str.charAt(i))
                    && !Character.isDigit(str.charAt(i))) {
                n++;
                flg4 = true;
            }
        }
        if (n >= 3) {
            return true;
        }
        return false;
    }

    /* private static boolean substrOK(String str){
         //用哈希map存字符串的每一位，key为字符，value为出现的下标
         // 插入前判断hm中是否存在
         // 如果存在则判断value起始的字符串和从i起始的字符串是否相等，
         // 如果超过3位相等则直接返回false
         // 如果少于三位则继续往hm中存i+1。。。
         HashMap<Character,Integer> hm = new HashMap<>();
         boolean flg = false;
         for (int i = 0; i < str.length()-1; i++) {
             int value = hm.getOrDefault(str.charAt(i),-1);
             if(value != -1){
                 for (int j = i+1,k = value+1; j < i+3 && j < str.length(); j++,k++) {
                     if(str.charAt(j) != str.charAt(k)){
                         flg = true;
                         break;
                     }
                 }
                 if(!flg){
                     return false;
                 }
             }else{
                 hm.put(str.charAt(i),i);
             }
         }
         return true;
     }
 */
    private static boolean substrOK(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            String s = str.substring(i, i + 3);
            for (int j = i + 1; j < str.length() - 2; j++) {
                if (str.substring(j).contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (lenthOK(str) && charnumOK(str) && substrOK(str)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
}
/*
  import java.util.Scanner;

 public class Main {
     // 长度超过8位
     public static boolean checkLength(String password) {
         if(password.equals(null) || password.length() <= 8){
             return false;
         }
         return true;
     }
     // 包括大小写字母.数字.其它符号,以上四种至少三种
     public static boolean checkCharKinds(String password) {
         int uppercase = 0, lowercase = 0, digit = 0, other = 0;
         char[] ch = password.toCharArray();
         for(int i = 0; i < password.length(); i++) {
             if(Character.isUpperCase(ch[i])) {
                 uppercase = 1;
             } else if(Character.isLowerCase(ch[i])) {
                 lowercase = 1;
             } else if(Character.isDigit(ch[i])) {
                 digit = 1;
             } else {
                 other = 1;
             }
         }
         if(uppercase + lowercase + digit + other >= 3) {
             return true;
         }
         return false;
     }
     // 不能有相同长度超2的子串重复
     public static boolean checkCharRepeat(String password) {
         for(int i = 0; i < password.length() - 2; i++) {
             String str = password.substring(i, i + 3);
             for(int j = i + 1; j < password.length() - 2; j++) {
                 if(password.substring(j).contains(str)) {
                     return false;
                 }
             }
         }
         return true;
     }

     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         while (sc.hasNextLine()) {
             String password = sc.nextLine();
             if(checkLength(password) && checkCharKinds(password) && checkCharRepeat(password)){
                 System.out.println("OK");
             } else {
                 System.out.println("NG");
             }
         }
         sc.close();
     }*/