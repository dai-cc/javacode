package day47;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
* 马戏团
* 正整数N表示人员个数，之后N行，每行3个数，分别对应马戏团人员的编号，体重和身高
* 上面的人应该既比下面的人矮，又比下面的人瘦，或者相等
* 输出能叠出的最高罗汉塔的高度
* */
public class Cicus {
    /*
    * 实际上是求一个最大升序子序列
    * */
    static class People{
        int height;
        int weight;

        public People(int weight ,int height){
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            People[] arr = new People[N];
            for (int i = 0; i < N; i++) {
                int index = sc.nextInt();
                arr[index-1] = new People(sc.nextInt(),sc.nextInt());
            }

            //开始对人员排序
            Arrays.sort(arr, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    int res = Integer.compare(o1.height,o2.height);
                    if(res != 0){
                        return res;
                    }else {
                        return Integer.compare(o1.weight,o2.height);
                    }
                }
            });

            int[] dp = new int[N];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
                for (int j = i-1; j >= 0; j--) {
                    if(arr[i].weight >arr[j].weight ||
                            (arr[i].weight == arr[j].weight && arr[i].height == arr[j].height)){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                max = Math.max(dp[i],max);
            }
            System.out.println(max);
        }
    }
}
