package day31;

import java.util.LinkedHashMap;
import java.util.Scanner;

/*
??????????????????????????????????
* 简单的错误记录
* 一行或多行字符串，每行包括带路径文件名称 出现错误的行号
* 记录的错误不能出现路径，只包含文件名称和出现错误的行号
* 如果文件名长度超过16，则输出后16个字符
* 最终按照错处出现的数目从多到少排序，
* 数目相同的情况下按照输入第一次出现的顺序排序
* 最多有八条记录，如果超出8条只输出前八条
* E:\V1R2\product\fpgadrive.c 1325
* fpgadrive.c 1325 1
*/
public class EasyMisCout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //建立一个数组，保存每行的错误数据
            String[] s = new String[8];
            LinkedHashMap<String,Integer> hm=new LinkedHashMap<>();
            for (int i = 0; i < 8; i++) {
                s[i] = sc.nextLine();
                String str = s[i];
                for (int j = str.length()-1; j >= 0; j--) {
                    if(str.charAt(j)=='\\'){
                        str = str.substring(j+1);
                        hm.put(str,hm.getOrDefault(str,0)+1);
                        //System.out.println(str);
                        break;
                    }
                }
            }
            for (String x:hm.keySet()) {
                System.out.println(x);
            }
        }
    }
}
