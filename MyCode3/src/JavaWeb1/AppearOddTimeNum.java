package JavaWeb1;

import java.util.HashMap;
import java.util.Scanner;

/*
* 数组中值出现了一次的数字
* 给定数字arr其中只有两个数字出现了奇数次，其他数字都出现了偶数次，
* 按照从小到大的顺序输出这两个数
* */
public class AppearOddTimeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            HashMap<Integer,Integer> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int key = sc.nextInt();
                hm.put(key,hm.getOrDefault(key,0)+1);
            }
            StringBuffer sb = new StringBuffer();
            for (Integer key: hm.keySet()) {
                int value = hm.get(key);
                if(value % 2 != 0){
                    sb.append(key);
                    sb.append(" ");
                }
            }
            String[] strs = sb.toString().split(" ");
            //System.out.println(sb);

            if(Integer.parseInt(strs[0]) > Integer.parseInt(strs[1]) ){
                System.out.print(strs[1]+" "+strs[0]);
            }else{
                System.out.print(strs[0]+" "+strs[1]);
            }
        }
    }
}
