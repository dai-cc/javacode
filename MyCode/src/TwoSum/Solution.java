package TwoSum;

import java.util.HashMap;
import java.util.HashSet;

/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/
public class Solution {
    //方法二：新建一个哈希表，遍历元素将元素往哈希表中添加，
    // 添加x的同时判断表中是否包含元素y满足x+y=target，
    // 若包含则返回x,y的下标
    // 不满足则抛出异常
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("没有满足条件的参数！");
    }


    //方法一：直接在数组中寻找是否满足条件的元素
    public int[] twoSum(int[] nums, int target) {
        /*遍历数组，假设ret[0]==nums[i] 依次比较i~length-1的元素，有则返回
         * 没有则i++继续寻找*/
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==target-nums[j]){
                    return new int[] {i,j};
                }

            }

        }
        throw new IllegalArgumentException("数组中没有满足条件的参数！");
    }
}
