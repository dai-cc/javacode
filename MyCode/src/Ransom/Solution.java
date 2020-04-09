package Ransom;
/*
给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
如果可以构成，返回 true ；否则返回 false。
(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

注意：
你可以假设两个字符串均只含有小写字母。
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
public class Solution {
  /*  这种方法不可行 是因为这种判断canConstruct("aa","ab")时返回true
        public static boolean canConstruct(String ransomNote, String magazine) {
        *//*ransomNote.charAt[i]遍历字符串 每遍历一个查看magazine中是否包含 包含则i++
        不包含直接退出返回false*//*
        int flag = -1;
        if(magazine.length()<ransomNote.length()){ return false;}
        for (int i = 0; i < ransomNote.length(); i++) {

            for(int j=0;j < magazine.length();j++) {
                if(ransomNote.charAt(i) == magazine.charAt(j)){
                    flag = 1;
                    break;
                }
            }

            if(flag == -1) {
                return false;
            }
        }
        return true;
    }*/
    public static boolean canConstruct(String ransomNote, String magazine){
        //先判断字符串长度，若ransomNote>magazine则直接返回false
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        int[] arr = new int[26];
        //统计magazine中各字母出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)-'a']++;
        }
        //再统计ransomNote中各字母出现的次数，相减为负则返回false
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i)-'a']--;
            if(arr[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(canConstruct("aa","abaab"));
    }
}
