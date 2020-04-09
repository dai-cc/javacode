package FindKth;
/*根据快排思路找出数组中第k大的数，
* 给定一个整数数组a,他的大小n，和要找的数字k
* 返回第k大的数*/

/*思路：
*   1. 指定数组最后一个元素为key，定义两个变量，一个从右遍历数组，一个从左遍历数组
*       当找到left>key时left停止，让right开始遍历找right<=key，
*       如果找到的话那么交换left和right
*       如果没有找到的话，当left=right那么就将key和left所指的值交换
*       此时key所在的位置左边全比自己小，右边全比自己大
*   2. 此时记录key所在的下标，说明它是第a.length -1大
*   3. 比较k和a.length-1的大小，如果>则说明在数组的右边，小于则说明在数组的左边，=则直接返回该值*/
public class Finder {
    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static int quilcSort(int[] arr,int i,int j){
        int left = i;
        int right = j;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, left, i);
        return left;
    }
    public static int findKth(int left,int right,int[] arr,int K){
        int index = quilcSort(arr,left,right);
        if((index - left)>(K-1) && left < right) {
            return findKth(left, index - 1, arr, K);
        }else if((index-left)<(K-1)&&left<right){
            return findKth(index+1,right,arr,K-index+left-1);
        }else{
            return arr[index];
        }

    }

    public static int findKth(int[] a, int n, int K) {
        return findKth(0,n-1,a,K);

        }
//        while(true){
//            if(index == K){
//                //说明index下标所在的数字刚好是第k大的数
//                return a[index];
//            }else if(index > K){
//                index = n - quilcSort(a, n-index+1,n-1);
//            }else if(index < K){
//                index = n - quilcSort(a,0,n - index -1);
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,2};
        System.out.println(findKth(arr,5,3));
    }
}
