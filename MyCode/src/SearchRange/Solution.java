package SearchRange;
/*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]

示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
*/
public class Solution {
    public static int rightRange(int[] nums,int target){
        if(nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = (left + right)/2;
            if(target == nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }
        }
        //left == nums.length说明target比所有数都大，返回-1
        if(left == 0){
            return -1;
        }
        return nums[left-1]==target?(left-1):-1;
    }


    public static int leftRange(int[] nums,int target){
        if(nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = (left + right)/2;
            if(target == nums[mid]){
                right = mid;
            }else if(target < nums[mid]){
                right = mid + 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }
        }
        //left == nums.length说明target比所有数都大，返回-1
        if(left == nums.length){
            return -1;
        }
        return nums[left]==target?left:-1;

    }
    //因为要求算法时间复杂度为O(log n) ，所以使用二分查找法
    public static int[] searchRange(int[] nums, int target) {
        int[] arr = {-1,-1};
        arr[0] = leftRange(nums,target);
        arr[1] = rightRange(nums,target);
        return arr;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target = 8;
        int[] arr = searchRange(nums,target);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
