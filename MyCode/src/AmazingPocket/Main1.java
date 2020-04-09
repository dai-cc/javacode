package AmazingPocket;

import java.util.Scanner;

/*
* 输入n行数据，保证选中的数字加起来是40
* 返回可以选的方法数
* 输入数据说明：
* 第一行是不同物品的数目（也就是有几个数据）
* 后面n行是1~40的正整数
* */
public class Main1 {
    static int count;
    static int[] arr;
    //可以采用递归的方法做
    //sum代表背包的剩余容量，res代表还剩下几件东西
    private static int amazingPocket(int sum, int res){
        if(sum == 0){
            //如果此时剩余容量等于0，就说明这种装法可以，count++
            return 1;
        }
        if(sum < 0){
            //说明不能刚好到40
            return 0;
        }
        if(res == 0){
            //如果说余量为0了，那就判断最后的这一个arr[0]是否刚好等于余量
            //等于余量则刚好相等，不等于则说明不可以
            return arr[0]==sum?1:0;
        }
        return amazingPocket(sum,res-1)+amazingPocket(sum-arr[res],res-1) ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //开辟一个数组
        while(sc.hasNext()){
            int n = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            count = amazingPocket(40,n-1);
            System.out.println(count);
        }
    }

}
