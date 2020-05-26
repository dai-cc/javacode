package day43;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
* 电话号码
* 每组数据第一行包含一个正整数n，紧接着n行每行包含一个电话号码
* 电话号码仅由连字符“-”，数字和大写字母组成，没有连续出现得连字符，且排除连字符后长度始终为7
* */
public class PhoneNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();

            String[] arr = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

            HashSet<String> hs = new HashSet<>();
            //要将结果按照字典序"xxx-xxxx"的形式输出，且要求结果不重复，
            // 每个电话号码占一行，且每组数据输出一个空行作为间隔符
            while (n-- != 0){
                String s = sc.next();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < s.length(); i++) {
                    // 如果是数字则直接添加进去
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                        sb.append(s.charAt(i));
                    }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                        for (int j = 0; j < arr.length; j++) {
                            if(arr[j].contains(s.charAt(i)+"")){
                                sb.append(j+2);
                                break;
                            }
                        }
                    }
                    if(sb.length() == 3){
                        sb.append("-");
                    }
                }
                s = sb.toString();
                if(s.length()==8){
                    hs.add(s);
                }
            }
            String[] a = new String[hs.size()];
            int k = 0;
            for (String phone: hs) {
                a[k++] = phone;
            }
            Arrays.sort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
            System.out.println();
        }
    }
}
