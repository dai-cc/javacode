package day24;

import java.util.Scanner;

/*
* 小易的初始能力值a,n个怪物的防御力为b1,b2,b3,...bn
* 如果遇到的怪物防御力bi<=c(小易当前能力值)，那么c=c+bi
* 如果bi>c,c += (c和bi的最大公约数)
* 输入第一行两个整数表示怪物数量n和小易初始能力值a
* 第二行n个整数表示每个怪物的防御力
* 求最终能力值？*/
public class YiGame {
    //用辗转相除法求最大公约数
    private static int yueshuMax(int x,int y){
        //先让x为大一些的数
        if(x < y){
            int temp = x;
            x = y;
            y = temp;
        }
        int z = x % y;
        while(z!=0){
            x = y;
            y = z;
            z = x % y;
        }
        return y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            //怪兽数量
            int n = sc.nextInt();
            //小易初始能力值
            int a = sc.nextInt();
            //各怪兽防御力
            int[] b = new int[n];
            for (int i = 0; i <n ; i++) {
                b[i] = sc.nextInt();
                //如果遇到的怪物防御力bi<=c(小易当前能力值)，那么c=c+bi
                if(b[i] <= a){
                    a += b[i];
                }else {
                    //如果bi>c,c += (c和bi的最大公约数)
                    a += yueshuMax(a,b[i]);
                }
            }
            System.out.println(a);
        }
    }
}
