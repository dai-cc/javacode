package DBExam;

import java.util.Scanner;
import java.util.HashMap;

public class Chicken{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> hm = new HashMap<>();
        while(sc.hasNext()){
            //思路：
            //用hashmap来统计所有不同材料
            //key---材料名
            //value---材料用到的次数
            //如果能够添加成功则count++

            String key = sc.next();
            int value = hm.getOrDefault(key,0);

            hm.put(key,value);
        }
        System.out.println(hm.size());
    }
}
