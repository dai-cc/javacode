package com.dai;

import java.util.HashSet;

/*给定一个整数数组，判断是否存在重复元素。
如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:
输入: [1,2,3,1]
输出: true

示例 2:
输入: [1,2,3,4]
输出: false

示例 3:
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
*/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*思路一：
        创建一个HashSet集合，遍历整数数组，将数组元素添加进集合中，
        查看add返回值判断插入是否成功，
        成功则继续，
        不成功则寿命存在重复值，返回true
        */
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;  i<nums.length ; i++) {
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;

        /*思路二：
        还可以先对数组进行排序，排序后若有相同元素则这些元素则一定相邻，所以只需判断相邻元素是否相同即可
        */
    }
}
