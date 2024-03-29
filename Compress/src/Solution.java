/*
给定一组字符，使用原地算法将其压缩。
压缩后的长度必须始终小于或等于原数组长度。
数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
在完成原地修改输入数组后，返回数组的新长度。
进阶：
你能否仅使用O(1) 空间解决问题？

示例 1：
输入：
["a","a","b","b","c","c","c"]
输出：
返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
说明：
"aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。

示例 2：
输入：
["a"]
输出：
返回1，输入数组的前1个字符应该是：["a"]
说明：
没有任何字符串被替代。

示例 3：
输入：
["a","b","b","b","b","b","b","b","b","b","b","b","b"]
输出：
返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
说明：
由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
注意每个数字在数组中都有它自己的位置。
注意：
所有字符都有一个ASCII值在[35, 126]区间内。
1 <= len(chars) <= 1000。*/
public class Solution {
    public static int compress(char[] chars) {
        int num = 0;//因为chars[j++]后j无法作为当前字母的下标，
        // 所以要专门设置一个值来记录chars[j++] = chars[i];时j的坐标，否则无法判断有几个相同字母
        int j = 0;//新数组的下标
        for (int i = 0; i < chars.length; i++) {
            //当i遍历完整个数组或者当前字符和下一个字符不同时，
            if(i==chars.length-1||chars[i]!=chars[i+1]){
                //注意判断条件的顺序if(i==chars.length-1||chars[i]!=chars[i+1])
                //要先判断是否遍历完，再判断当前字符和下一个字符是否不同，
                //若判断条件写反，会报数组越界错误
                chars[j++] = chars[num];
                if(i > num){
                    for (char c: ("" + (i - num + 1)).toCharArray()) {
                        chars[j++] = c;
                    }
                }
                num = i + 1;
            }
        }
        return j;
    }
               /* int anchor = 0, write = 0;
                for (int read = 0; read < chars.length; read++) {
                    if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                        chars[write++] = chars[anchor];
                        if (read > anchor) {
                            for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                                chars[write++] = c;
                            }
                        }
                        anchor = read + 1;
                    }
                }
                return write;
            }*/

    public static void main(String[] args) {
        char[] ch = {'a','b','b','b','b','b'};
        System.out.println(compress(ch));
    }
        }

