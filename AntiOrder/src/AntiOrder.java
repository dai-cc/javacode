/*
* 有一组数，对于其中任意两个数组，若前面大于后面一个数字，
* 则这两个数字组成一个逆序对，返回给定数组中逆序队个数
* */

public class AntiOrder {
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int count(int[] A, int n) {
        //设置两个指针i,j，两个分别从0，1开始，
        // 比较ij所指向数字的大小关系
        //  i>j：count++,继续后移
        //  i<=j:j后移继续比较，直到找到比i小的，或者遍历完数组
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if(A[j] > A[j+1]){
                    swap(A,j,j+1);
                    count++;
                }
            }
        }
        return count;
    }
    public static int count1(int[] A, int n) {
        //设置两个指针i,j，两个分别从0，1开始，
        // 比较ij所指向数字的大小关系
        //  i>j：i不动，j后移 count++，注意ij的范围不能超过数组的长度
        //      如果j到数组末尾了还是比i小的话，则i++,j=i+1,继续比较
        //  i<=j:i和j同时后移
        // 不可以这样算，因为比如说1，2，4，3，3比4小不一定比前面所有都小
        int i = 0;
        int count = 0;
        while (i < n-1){
            int j = i+1;
            while(A[i] <= A[j]){
                i++;
                j++;
            }
            while(A[i] > A[j]){
                count += j;
                if(j == n-1){
                    break;
                }
                j++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {8,2,4,5,6,7,0};
        int n = A.length;
        System.out.println(count(A,n));
    }
}
