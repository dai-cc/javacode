package PlusOne;
/*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
*/
public class Solution {
    public static int[] plusOne(int[] digits) {
        /*若数组末位<9 则直接将末位的数组加1即可
        * 若数组末尾=9 则需考虑进位问题*/
        int end = digits.length-1;

        if(digits[end]<9) {
            digits[end] += 1;
        }else{
            digits[end]=0;
            for (int i = end-1; i >= 0; i--) {
                if(digits[i] < 9){
                    digits[i] += 1;
                    break;
                }else{
                    digits[i] = 0;
                }
            }
            if(digits[0] == 0){
                int[] arr = new int[end+2];
                arr[0] = 1;
                return arr;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        plusOne(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
