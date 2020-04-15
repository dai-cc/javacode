package day14;

import java.util.Arrays;
import java.util.Scanner;

/*
*   给定0-9若干个数字，热议排列这些数字，使最后得到的数字尽可能小
*   输入的分别代表0 1 2...9的个数*/
public class CreateMinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //将这些数字先用字符串保存起来，最后转移到数组中，进行排序
            int[] nums = new int[10];
            int len = 0;
            for(int i = 0; i < nums.length;i++){
                nums[i] = sc.nextInt();
                len += nums[i];
            }
            StringBuffer sb = new StringBuffer();
            //从1开始遍历，找第一个个数不为0的数字，将他添加到数组中
            for (int i = 1; i < nums.length; i++) {
                //注意为了保证是最小的，所以他只添加一个就可以了
                if(nums[i] != 0){
                    sb.append(i);
                    nums[i]--;
                    break;
                }
            }
            //然后开始遍历数组，由于第一位已经是非0数，所以剩下的直接照挪就可以了
            for (int i = 0; i < nums.length; i++) {
                while(nums[i] != 0){
                    sb.append(i);
                    nums[i]--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
