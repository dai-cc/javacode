package day39;
/*
* 二维数组打印
* 给定一个二维数组（n*n），写程序实现从右上角到左下角沿主对角线方向打印，
* 给定一个二维数组arr，以及题目中的参数n，返回结果数组*/
public class PrintDoubleArray {
    public static int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] a = new int[n*n];
        int len = 0;
        //打印上三角（对角线以上）
        for (int k = n-1; k >= 0; k--) {
            for (int i = 0,j = k; i < n && j < n; i++,j++) {
                a[len++] = arr[i][j];
            }
        }
        //打印下三角
        for (int k = 1; k < n; k++) {
            for (int i = k,j = 0; i < n && j < n-k; i++,j++) {
                a[len++] = arr[i][j];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        arrayPrint(arr,4);
    }
}
