package Rotate;
/*
* 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
* 输入: [1,2,3,4,5,6,7] 和 k = 3
  输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

step1: 先整体反转数组
step2: 反转前k个元素
step3: 反转后length-k个元素
*/
public class Solution {
    public void rotate(int[] nums, int k) {
    /*
    * 1.k 是非负数 所以旋转步数=k%数组长度
    * 2.从数组末端right开始置换到right-k的位置 置换数组长度-k次
    */
    //判断数组是否为空,是否存在该数组，k是否为非负数
        if(nums==null || nums.length==0 || k<0){
            return;
        }
        k = k%nums.length;
        //当旋转数等于数组长度时不用反转
        if(k==nums.length){
            return;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    //反转元素
    public static void reverse(int[] nums,int left,int right){
        while(left<=right) {
            int temp = nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            right--;
            left++;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        int k=4;
        Solution solution = new Solution();
        solution.rotate(nums,k);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
