package LengthOfLastWord;
/*
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。

示例:
输入: "Hello World"
输出: 5
*/
public class Solution {
    public static int lengthOfLastWord(String s) {
        /*先判断字符串是否为空，若为空字符串则返回0
        不为空则判断最后一位是否为“” 若是则去掉空格后再
        从后往前遍历
        有空格：遇到第一个空格
                判断该空格是否再字符串最后一个，若是则继续找下一个空格
                不是则最后的单词长度就为字符串长度-空格下标-1
        没空格：返回字符串长度-1

        开辟一个数组记录空格所在位置下标
        判断数组长度
        =0  没有空格 且字符串不为空 所以返回字符串长度-1
        >0  判断空格是否再最后一个位置（arr[arr.length-1]==str.length）
        */
            int right = s.length() - 1;
            while (right > 0 && s.charAt(right) == ' ') {
                right--;
            }
            if (right < 0) {
                return 0;
            }
            int left = right;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            return right - left;
        }


    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("s "));
        //System.out.println("str".equals("str"));
    }
}
