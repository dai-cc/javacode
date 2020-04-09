package PivotIndex;
/*给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

示例 1:
输入:
nums = [1, 7, 3, 6, 5, 6]
输出: 3
解释:
索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
同时, 3 也是第一个符合要求的中心索引。

示例 2:
输入:
nums = [1, 2, 3]
输出: -1
解释:
数组中不存在满足此条件的中心索引。
*/
public class Solution {
    public static int pivotIndex(int[] nums) {
        /*定义中心索引p为1，判断p左侧元素和与右侧元素和的大小关系
         *  == 返回p
         *  > 返回-1
         *  < p++ 若p>=arr.length都没有找到 则返回-1*/

        int Asum = sum(nums,0,nums.length);
        int leftsum =0;
        //int p = 1;//中心索引
        for (int p = 0 ; p < nums.length ; p++){
            if(leftsum==Asum-leftsum-nums[p]){
                return p;
            }
            leftsum += nums[p];
        }
        return -1;
    }

    public static int sum(int[] arr,int start,int end){
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr ={1, 7, 3, 6, 5, 6};
        //System.out.println(sum(arr,0,2));
        System.out.println(pivotIndex(arr));
    }
}
