package com.dai;
/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。

示例 1:
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

说明 :
输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。
*/
public class Solution {
    public static int findUnsortedSubarray(int[] nums) {
        //设置两个指针i从前往后遍历，j从后往前遍历
        int i = 0;
        //int j = nums.length-1;
        //i遍历时用max记录所遍历过的最大的值，j遍历时用min记录遍历过的最小值
        int max = nums[0];
        int min = nums[nums.length-1];
        //用left 和right表示子数组的左右边界
        int left = 0,right = 0;
        for (i = 0; i < nums.length; i++) {
            //从前往后遍历，找出子数组右边界
            if(max>nums[i]){
                //判断max和当前的nums[i]大小关系
                //如果不是正常升序数组，则更新右边边界
                right = i;
            }else{
                //如果是正常升序数组即（max<=nums[i]）max和min一定会是当前i,j所指位置，那么max,min挪到i,j的位置
                max = nums[i];
            }
            //从后往前遍历找数组左边界
            if(min<nums[nums.length-i-1]){
                left = nums.length-i-1;
            }else{
                min = nums[nums.length-i-1];
            }
        }

        //子数组的长度就是right-left+1
        return right - left +1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(findUnsortedSubarray(arr));
    }
}
