package day0824;

/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
*/
public class minNumberInRotateArray {
    // 用二分法
    public int minNumberInRotateArray(int [] array) {
       // 非递减数组：递增或全都是一样的值
        int low = 0;
        int high = array.length-1;

        while (low < high){
            int mid = (high + low)/2;
            // mid > high 说明最小的数字一定是在mid右边 [2,3,4,0,1]
            // 查找范围就缩小到【mid+1，high]
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] < array[high]){
                // 说明右半边一定是递增的，此时最小数子应该在mid左边[1,2,3,4,5]
                high = mid;// 注意这个地方不能是mid-1，因为当最后数字只剩两个的时候，mid一定指向下标靠前的数字，如果mid-1的话，会数组越界
            }else if(array[mid] == array[high]){
                // 此时只能是【1，0，1，1，1】或者【1，1，1，0，1】或者【1,1,1,1,1】这种情况
                // 这种只能一个一个缩小范围试
                high = high - 1;
            }
        }
        // 退出时low==high，都指向了数组中最小的数
        return array[low];
    }
}
