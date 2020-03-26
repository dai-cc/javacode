package sort;

public class InsertSort {
    public static  void selectSort(int[] array){
        //选择的趟数
        for (int i = 0; i < array.length-1; i++) {
            //具体选择的方式,找最大元素的位置
            int maxPos = 0;
            for (int j = 1; j < array.length - i; j++) {
                if(array[j] > array[maxPos]){
                    maxPos = j;
                }
            }
            if(maxPos != array.length-1-i){
                swap(array,maxPos,array.length-1-i);
            }
        }
    }
    public static void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    //希尔排序
    public static  void shellSort(int[] array){
        int gap = array.length;
        while(gap > 0){
            gap = gap/3+1;//也有说gap每次除2，也有说每次取素数
            for (int i = gap; i < array.length; i++) {
                //找待插入元素在前面已经排好序的部分的位置
                int key = array[i];
                int end = i -gap;

                //注意考虑待插入元素为最小元素的情况
                while(end >= 0 && key < array[end]){
                    array[end +gap] = array[end];
                    end -= gap;
                }
                array[end + gap] = key;
            }
            gap--;
        }

    }

    //直接插入排序
    public static  void insertSort(int[] array){
        for (int i = 1; i < array.length; ++i) {
            //找待插入元素在前面已经排好序的部分的位置
            int key = array[i];
            int end = i -1;

            //注意考虑待插入元素为最小元素的情况
            while(end >= 0 && key < array[end]){
                array[end +1] = array[end];
                end--;
            }
            array[end+1] = key;
        }

    }
    public static  void printArr(int[] array){
        for (int x:array) {
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,0,4};
        //insertSort(arr);
        //shellSort(arr);
        selectSort(arr);
        printArr(arr);
    }
}
