package day1011;

import java.util.Scanner;

/*
* 给定一个数组，第i个元素是一只股票第i天的价格，如果最多只允许完成一笔交易，计算最大利润
* */
public class Solution2 {
    private static int maxMoney(int[] nums){
        // 其实就是找数组最大差值
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                max = Math.max(max,nums[j]-nums[i]);
            }
        }
        // 因为有可能max为负数，如果他为负数的话直接返回0
        return Math.max(max,0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String[] strings = s.split(",");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(maxMoney(nums));
        }
    }
}
