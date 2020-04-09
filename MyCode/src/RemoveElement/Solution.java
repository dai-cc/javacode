package RemoveElement;
/*
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
示例 1:
给定 nums = [3,2,2,3], val = 3,
函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
你不需要考虑数组中超出新长度后面的元素。
*/
public class Solution {
    public static int removeElement(int[] nums, int val) {
        //返回的Int是删除后数组的长度
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
    /*    public int removeElement(int[] nums, int val) {
            //返回的Int是删除后数组的长度
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if(nums[i]==val){
                    //如果当前值和val值相同则删除，len-1
                     nums[i] = nums[i+1];
                    len--;
                }
            }
            return len;
        }
    }
    这种不可以，因为这种没有考虑连续两个元素相同时的情况*/
    public static void main(String[] args) {
        int[] arr = {3,2,2,2,3};
        int val = 2;
        int len = removeElement(arr,val);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}
