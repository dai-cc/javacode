package ThirdMax;
/*给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

示例 1:
输入: [3, 2, 1]
输出: 1
解释: 第三大的数是 1.

示例 2:
输入: [1, 2]
输出: 2
解释: 第三大的数不存在, 所以返回最大的数 2 .

示例 3:
输入: [2, 2, 3, 1]
输出: 1
解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。
*/
public class Solution {
    public int thirdMax(int[] nums) {
        /*用abc分别代表第一大数，第二大，第三大，
        先假设a是nums[0],遍历数组，
        若有比a大或相等的 则a等于这个新数，b等于a，以此类推，
        遍历完数组后判断ab,bc,ac是否相等，
            若相等则返回a，
            不相等返回c
        */
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        boolean f=true;
        int flag=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==Integer.MIN_VALUE&&f){
                flag++;
                f=false;
            }
            if(nums[i]>max1){
                flag++;
                //原先第二大传递给第三大
                max3=max2;
                //原先最大值传递给第二大
                max2=max1;
                //更新最大值
                max1=nums[i];
            }else if (nums[i]>max2 && nums[i]<max1){
                flag++;
                max3=max2;
                max2=nums[i];
            } else if( nums[i]>max3 && nums[i]<max2){
                flag++;
                max3=nums[i];
            }
        }
        return flag>=3?max3:max1;
    }
}

