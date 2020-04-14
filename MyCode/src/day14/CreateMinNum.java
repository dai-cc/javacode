package day15;

import java.util.Arrays;
import java.util.Scanner;

/*
*   给定0-9若干个数字，热议排列这些数字，使最后得到的数字尽可能小*/
public class CreateMinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //将这些数字先用字符串保存起来，最后转移到数组中，进行排序
            String n = sc.nextLine();
            String[]  nums = n.split(" ");
            Arrays.sort(nums);
            //排完序后查看第一个位置是否为0
            if(nums[0].equals("0")){
                //为0则将这个数与第二小的数交换
                for (int i = 1; i < nums.length; i++) {
                    if(!nums[i].equals("0")){
                        nums[0] = nums[i];
                        nums[i] = "0";
                        break;
                    }
                }
            }
            //不为零则说明该数已经是最小数,输出该数
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
            }
        }
    }
}
