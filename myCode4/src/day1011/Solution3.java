package day1011;

import java.util.Arrays;

/*
* 合并两个有序数组
* 如果这两个数组是升序的，合并后的数组是降序
* 如果这两个数组是降序的，合并后的数组是升序的*/
public class Solution3 {
    private static boolean arrSort(int[] arr){
        // 判断数组升序还是降序
        // 降序返回false,非降序返回true
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    private static int[] reverse(int[] arr){
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return arr;
    }
    public int[] mergeToReversed (int[] A, int[] B) {
        // 先判断是升序还是降序,注意考虑{0，0，0，0}的情况，和数组中只有一个元素的情况
        int len = A.length + B.length;
        int[] arr = Arrays.copyOf(A,len);
        boolean f = false;
        if(arrSort(A) || arrSort(B)){
            f = true;
        }
        for (int i = A.length,j=0; i < len; i++,j++) {
            arr[i] = B[j];
        }
        Arrays.sort(arr);
        if(!f) {
            return arr;
        }
        return reverse(arr);
    }
}
