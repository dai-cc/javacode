package MergeTwoArr;
/*
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

*/
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*设置两个指针分别指向num1 num2，比较nums1[i],nums2[j],
        * nums1[i]>=nums[j] 将后面的元素整体后移，将nums[j]插入到当前位置
        * nums1[i]<nums[j] i后移继续比较
        * 需要设计一个指针p防止nums2中有元素没有录上*/
        int j=0;
        for (int i = 0; i < m; i++) {
            while(j<n){
                if(nums1[i]<nums2[j]){
                    break;
                }else{
                    m++;
                    insert(nums1,i,m,nums2[j]);
                    j++;
                    break;
                }
            }
        }
        if(m<nums1.length){
            for (int i = m; i < nums1.length; i++) {
                nums1[i]=nums2[j];
                j++;
            }
        }
    }
    public static void insert(int[] nums,int start,int m,int num){
        for (int i = m-1 ; i > start; i--) {
            nums[i]=nums[i-1];
        }
        nums[start]=num;
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=3;
        int n=3;
        merge(nums1,m,nums2,n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }


    }
}
