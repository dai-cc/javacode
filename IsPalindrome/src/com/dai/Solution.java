package com.dai;
/*判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。*/
public class Solution {
    public static boolean isPalindrome(int x) {
        String str = x + "";
        for(int left = 0,right = str.length()-1 ; left<=right ; left++,right--){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}