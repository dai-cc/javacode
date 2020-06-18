package JavaWeb1;

import java.util.Scanner;

/*
* 单调栈结构
* 给定不含重复值的数组arr，
* 找到每一个i位置左右离i最近且值比i小的位置，返回这个位置的下标
* */
public class MonStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int left = -1;
                int right = -1;
                for (int j = i-1; j >= 0; j--) {
                    if(arr[i] > arr[j]){
                        left = j;
                        break;
                    }
                }
                for (int j = i+1; j < n; j++) {
                    if(arr[i] > arr[j]){
                        right = j;
                        break;
                    }
                }
                System.out.println(left + " " + right);
            }
        }
    }
}
