package com.dai;
/*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:
输入: "race a car"
输出: false
*/
public class Solution {

        public static boolean isPalindrome1(String s) {
            int i = 0, j = s.length() - 1;
            while(i < j){
                while(i < j && !numOrWord(s.charAt(i))) i++;
                while(i < j && !numOrWord(s.charAt(j))) j--;
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
                i++; j--;
            }
            return true;
        }



    public static boolean isPalindrome(String s) {
        /*设置两个指针，一前一后，判断指针所指内容是否为数字或字母，
        如果不是则++或--
        如果同时为数字/字母则比较两者是否相同，
            相同则下一个
            不同则return false
        */

        int i = 0;
        int j = s.length()-1;
        boolean flag = false;
        while(i < j){
            while(i<j && !numOrWord(s.charAt(i))){
                i++;
            }
            while(i<j && !numOrWord(s.charAt(j))){
                j--;
            }
            if(s.charAt(i)==s.charAt(j)+32||s.charAt(i)==s.charAt(j)-32){
                i++;
                j--;
                flag = true;
            }
            if(s.charAt(i)!=s.charAt(j) && !flag){
                return false;
            }
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
        }
        return true;
    }
    public static boolean numOrWord(char ch){
        if((ch >='0'&&ch <= '9')||(ch >= 'a' && ch <= 'z')||(ch >='A' && ch <= 'Z')){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }
}
