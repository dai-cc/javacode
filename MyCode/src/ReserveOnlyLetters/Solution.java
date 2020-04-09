package ReserveOnlyLetters;
/*给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

 示例 1：
输入："ab-cd"
输出："dc-ba"

示例 2：
输入："a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"

示例 3：
输入："Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"
*/
public class Solution {
    public static String reverseOnlyLetters(String S) {
        /*创建两个变量分别指向字符串头部和尾部，
          若都为字符则互换，
          前者为非字母则i++,
          后者为非字母则j--
          都为非字母则位置不变i++ j--
        */
        char[] chars = S.toCharArray();
        int index = 0;
        int i = 0;
        int j = S.length()-1;
        //char[] chars = S.toCharArray();
        while(i < S.length() && j >= 0){
            if(isChar(S.charAt(i)) && isChar(S.charAt(j))){
                chars[i]=S.charAt(j);
                i++;
                j--;
            }else if(!isChar(S.charAt(i)) && isChar(S.charAt(j))){
                i++;
            }else if(!isChar(S.charAt(j)) && isChar(S.charAt(i))){
                j--;
            }else if(!isChar(S.charAt(i)) && !isChar(S.charAt(j))){
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    public static boolean isChar(char ch){
        if(ch>='A' && ch<='Z' || ch>='a' && ch<='z'){
            return true;
        }
        return false;
    }
    public static String reverseOnlyLetters1(String S) {
        /*创建一个新的字符串str，将字符串拷贝一份，
        然后反着遍历忘原数组中是字母的地方按序添加，
        不是字母的地方跳过*/
        char[] chars = S.toCharArray();
        int index = 0;
        for (int i = S.length()-1; i >= 0; i--) {
            if(S.charAt(i)>'A' && S.charAt(i)<'z' && chars[index]>'A' && chars[index]<'z'){
                chars[index++]=S.charAt(i);
            }/*else if(S.charAt(i)<'A' && S.charAt(i)>'z'){
                index++;*/
            if(chars[index]<'A' || chars[index]>'z') {
                index++;
                i++;
            }if((S.charAt(i)<'A' || S.charAt(i)>'z')&& (chars[index]<'A' || chars[index]>'z')){
                index++;
            }

        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
