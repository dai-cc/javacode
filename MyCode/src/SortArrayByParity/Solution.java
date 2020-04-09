package SortArrayByParity;
/*给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
你可以返回满足此条件的任何数组作为答案。

示例：
输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。

*/
public class Solution {
    public static int[] sortArrayByParity(int[] A) {
        /*定义一个和原数组大小一样的新数组
        设置两个指针 i指向数组第一个元素 j指向数组中最后一个元素
        然后遍历原数组 遇到偶数则放到i的位置 i++
        遇到奇数则放到j的位置 j++
        */
        int[] arr = new int[A.length];
        int i=0;
        int j=arr.length-1;

        for (int k = 0; k < A.length; k++) {
            if(A[k]%2==0){
                //偶数
                arr[i++]=A[k];
            }else{
                arr[j--]=A[k];
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        int[] arr=sortArrayByParity(A);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
