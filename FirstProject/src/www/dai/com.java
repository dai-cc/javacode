package www.dai;
/*
* 求数组最大值
* 求数组最小值
* 求数组平均值
* 将数组逆置
* 将数组当中奇数放在偶数前
* */


import java.lang.reflect.Array;
import java.util.Arrays;

public class com {
/*    public static int binarySearch(int[] array,int key,int left,int right){
        //递归实现二分法查找?????
        if(left>right){
            return -1;
        }
      int mid=(left+right)/2;
        if(array[mid]==key){
            return mid;
        }else if(array[mid]>key){
            return    binarySearch(array,key,left,mid-1);
        }else if(array[mid]>key) {
            return binarySearch(array, key, mid + 1, right);
        }
    }*/

    public static int[] inverse(int[] arr){
        //将数组逆置

        for (int j=arr.length-1,i=0;i <arr.length-1 && j>0; i++,j--) {
            arr[i]=arr[j];
        }
        return arr;
    }
    public static int aveNum(int[] arr){
        //求数组平均值
        int result=0;
        for (int i = 0; i <arr.length ; i++) {
            result+=arr[i];
        }
        int average=result/(arr.length);
        return average;
    }


    public static int minNum(int[] arr){
        //求数组最小值
        int min=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(min>arr[i]){
                min=arr[i];
            }
        }
        return min;
    }
    public static int maxNum(int[] arr){
        //求数组最大值
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={2,4,0,6};
        int max=maxNum(arr);
        int min=minNum(arr);
        int average=aveNum(arr);
        System.out.println(max);
        System.out.println(min);
        System.out.println(average);
        inverse(arr);
        for (int x:arr) {
            System.out.print(x+" ");
        }
    }
    public static String toString(int[] array){
  /*      System.out.print("[");
        for (int x:array) {
            System.out.print(x+" ");
        }
        System.out.print("]");*/
        String ret="[";
        for (int x:array) {
            ret=ret+x;
        }
        ret=ret+"]";
        return ret;
    }
    public static void main2(String[] args) {
        int[] arr={1,2,3};
        String ret=toString(arr);
        System.out.println(ret);
    }
    /*
     * 将数组中每个元素都乘以2
     * */
    public static int[] fun(int[] arr){
        for (int i = 0; i <4 ; i++) {
            arr[i]=arr[i]*2;
        }
        return arr;
    }
    public static void main1(String[] args) {
        int[] arr={1,2,3,4};
        int[] arr2=fun(arr);
        for (int x:arr2) {
            System.out.print(x+" ");
        }
    }
}
