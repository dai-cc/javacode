package day30;

/*
* 大整数排序
* 第一行为一个正整数N，接下来N行每行都有一个数，数的长度范围为1<=len<=1000
* 每个数都是一个正数，并且不包含前缀零
* 将N个数从小到大排序，输出排序后的结果，每个数占一行*/
import java.util.Arrays;
import java.util.Scanner;

public class BigDigitSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            String[] nums = new String[N];
            int[] len = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.next();
                len[i] = nums[i].length();
            }
            Arrays.sort(nums);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N-1; j++) {
                    if(nums[j].length() > nums[j+1].length()){
                        String temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }

            }
            for (int i = 0; i < N; i++) {
                System.out.println(nums[i]);
            }
        }
    }
}
