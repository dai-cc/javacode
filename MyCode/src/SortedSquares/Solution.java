package SortedSquares;

import javafx.geometry.Pos;

/*
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

 示例 1：
输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]

示例 2：
输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]

*/
public class Solution {
    public static int[] sortedSquares(int[] A) {
        /*先将数组排序 从前往后遍历找到最小正整数或0 令pos=该数下标 min=pos-1即为最大负数
        * while(min+pos!=A.length)判断|A[min]|和A[pos]大小
        * > 则pos++
        * <= 则将A[min]移至A[pos-1]处  min--
        * 排序完成后将数组元素平方*/
        if(A.length==1){
            A[0]=A[0]*A[0];
            return A;
        }
        int[] arr = new int[A.length];
        int min = 0;
        int pos = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] >= 0){
                pos = i;
                min = pos-1;
                break;
            }
        }
        int index = 0;//新数组下标
        while(min >= 0 && pos <A.length){
            if(Math.abs(A[min])>A[pos]){
                arr[index++]=A[pos]*A[pos];
                pos++;
            }else if(Math.abs(A[min])<=A[pos]){
                arr[index++]=A[min]*A[min];
                min--;
            }
        }
        while(min >= 0){
            arr[index++]=A[min]*A[min];
            min--;
        }
        while(pos < A.length){
            arr[index++] = A[pos]*A[pos];
            pos++;
        }
        return arr;
    }
/*    public static int[] quares(int[] A){
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) Math.pow(A[i], 2);
        }
        return A;
    }*/

    public static void main(String[] args) {
        int[] A = {-1};
        int[] arr=sortedSquares(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
