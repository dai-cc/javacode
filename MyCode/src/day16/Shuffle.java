package day16;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/*
* 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。
* 首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
* 在洗牌过程中按顺序放下了6,3,5,2,4,1。
* 把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
* 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
*
* 输入描述：
*   第一行一个数T(T ≤ 100)，表示数据组数。
*   对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，
*              接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。
*
* 输出描述：
*   对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格
*
*   输入：3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
*   输出：1 4 2 5 3 6 1 5 4 3 2 6 1 1 1 1
*
*   实际上可以看成
*      输入：3 （T=3,3组数据）
*           3 1(n=3,k=1,6张数据洗牌1次之后结果)
*           1 2 3 4 5 6 ====》 1 4 2 5 3 6
*           3 2(n=3,k=2,6张数据洗牌2次之后结果)
*           1 2 3 4 5 6 ====》 1 5 4 3 2 6
*           2 2(n=2,k=2,4张数据洗牌2次之后结果)
*           1 1 1 1 ====》  1 1 1 1
*/
//public class Shuffle {
//    private static int[] shuffle(int[] arr,int n,int k){
//        int[] buf = new int[2 * n];
//        while(k != 0) {
//            for (int i = 0; i < n; i++) {
//                buf[i * 2] = arr[i];
//                buf[i * 2 + 1] = arr[i + n];
//            }
//            k--;
//            System.arraycopy(buf,0,arr,0,buf.length);
//        }
//        return buf;
//
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()){
//            int T = sc.nextInt();
//            while(T-- > 0) {
//                int n = sc.nextInt();
//                int k = sc.nextInt();
//                int[] arr = new int[2*n];
//                for (int i = 0; i < arr.length; i++) {
//                    arr[i] = sc.nextInt();
//                }
//                int[] buf = shuffle(arr,n,k);
//                if(T == 0){
//                    for (int i = 0; i < buf.length-1; i++) {
//                        System.out.print(buf[i] + " ");
//                    }
//                    System.out.print(buf[buf.length-1]);
//                }else {
//                    for (int x : buf) {
//                        System.out.print(x + " ");
//                    }
//                }
//            }
//        }
//    }
//}
public class Shuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        while (groups-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] res = new int[2*n];
            for(int i=0;i<2*n;i++){
                int tmp = i + 1;
                for(int j = 0; j < k;j++){
                    if (tmp <= n) tmp = 2*tmp - 1;
                    else tmp = 2 * (tmp - n);
                }
                res[tmp - 1]=sc.nextInt();
            }
            //输出
            if(res.length> 0) System.out.print(res[0]);
            for(int i = 1;i< 2*n;i++){
                System.out.print(" "+res[i]);
            }
            System.out.println();
        }
    }
}