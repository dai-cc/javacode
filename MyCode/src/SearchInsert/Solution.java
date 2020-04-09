package SearchInsert;
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
示例 1:
输入: [1,3,5,6], 5
输出: 2
*/
public class Solution {
    public static int searchInsert(int[] nums, int target) {
    //找到数组中间的数nums[mid]，如果target>nums[mid]则找右半边,target<nums[mid] 则找左半边
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target>nums[mid]){
                //如果target>nums[mid]则找右半边
                left=mid + 1;

            }else if(target<nums[mid]){
                //如果target<nums[mid]则找左半边
                right=mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums,target));
    }
}
