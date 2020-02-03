package com;
/*
实现函数 ToLowerCase() ，该函数接收一个字符串参数 str ，并将该字符串中的大写字母转换成小写字母，
之后返回新的字符串 。
*/
public class Solution {

    public String toLowerCase(String str) {
        //判断str中是否有大写字母chatAt'A'-'Z'
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            //当该字符为大写字符时 将大写字母转化为相应的小写字母
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                ch[i]=(char)(str.charAt(i)-'A'+'a');
            }
        }
        //返回字符串
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str="aBCDefGh";
        //String newstr=solution.toLowerCase(str);
        System.out.println(solution.toLowerCase(str));
    }
}

