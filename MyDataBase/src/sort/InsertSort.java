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

    public static void shiftDown(int[] array,int parent,int size){
        int child = parent*2+1;
        while(child<size){
            //找左右孩子中较大的孩子
            if(child+1 <size && array[child+1]>array[child]){
                child += 1;
            }
            //
        }
    }
    //堆排序
    public static void heapSort(int[] array){
        //建堆
        //找倒数第一个非叶子节点
        int lastLeaf = (array.length-2)>>1;
        //从lastLeaf到root的位置不断向下调整
        for (int root = lastLeaf; root >= 0 ; root--) {
            shiftDown(array,root,array.length);
        }
        //利用堆删除的思想进行排序
        int end = array.length - 1;
        while(end >= 0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    //约定是左闭右开[left,right)
    public static void quickSort(int[] array,int left,int right){

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
