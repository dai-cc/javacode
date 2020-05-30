package day46;

import java.util.HashMap;

/*
* 数组中出现次数超过一半的数字
* 数组中有一个数字出现的次数超过数组长度的一般，找出这个数字
* 不存在输出0
* */
public class NumOccurrenceNumOverHalf {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int num = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int count = hm.getOrDefault(array[i],0) + 1;
            if(count > array.length/2){
                num = array[i];
                break;
            }
            hm.put(array[i],count);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
