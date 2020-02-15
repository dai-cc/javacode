package com.dai;
/*请你来实现一个 atoi 函数，使其能将字符串转换成整数。
首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:
输入: "42"
输出: 42

示例 2:
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

示例 3:
输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

示例 4:
输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。

示例 5:
输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
*/
public class Solution {
    /*  假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
        在任何情况下，若函数不能进行有效的转换时，请返回 0。

        说明：
        假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，
        请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
*/
    public static int myAtoi(String str) {
        //re返回值；negative负数；positive正数；isCal是否进行计算
        int re = 0,negative = 0,positive = 0,isCal = 0;
        //将字符串转换成字符数组用for-each进行遍历
        for(char t : str.toCharArray()){
            /*
             *排除前方的空格同时判断是否以除数字或者正负号以外的开头
             *如果是直接返回0
             */
            if(isCal == 0){
                if((t <= '9' && t >= '0') || t == ' ' || t == '-' || t == '+'){
                    ;
                }else{
                    return 0;
                }
            }
            //如果当前为0-9和正负号可计算，否则判断是否存在负号并进行return
            if((t <= '9' && t >= '0') || t == ' ' || t == '-' || t == '+'){
                if(t == '-'){
                    //如果前方存在正号即为"+-"则不合法返回0
                    if(positive == 1 ){
                        return 0;
                    }
                    //如果此负号前进行过计算则判断之前是否存在负号并进行return
                    if(isCal ==1){
                        if(negative == 1){
                            re = -re;
                        }
                        return re;
                    }
                    //如果是第一次遇到负号，将negative置1，同时把isCal置1代表计算过
                    negative=1;
                    isCal=1;
                }else if(t == '+'){
                    //同负号
                    if(negative == 1 ){
                        if(re !=0){
                            re = -re;
                            return re;
                        }else {
                            return 0;
                        }
                    }
                    if(isCal ==1){
                        if(negative == 1){
                            re = -re;
                        }
                        return re;
                    }
                    positive=1;
                    isCal=1;
                }else if (t == ' '){
                    //如果前方计算过又遇到空格则检查是否有负号并return
                    if(isCal != 0){
                        if(negative == 1){
                            re = -re;
                        }
                        return re;
                    }else if(isCal == 1){
                        return 0;
                    }
                }else {
                    if (negative == 1) {
                        int bbq = -re;
                        if (bbq < Integer.MIN_VALUE / 10 || (bbq == Integer.MIN_VALUE / 10 && t - 48 > 8)) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        if (re > Integer.MAX_VALUE / 10 || (re == Integer.MAX_VALUE / 10 && t - 48 > 7)) {
                            return Integer.MAX_VALUE;
                        }
                    }
                    re = re * 10 + t - 48;
                    isCal = 1;
                }
            }else if (isCal != 0){
                if(negative == 1){
                    re = -re;
                }
                return re;
            }
        }
        if(negative == 1){
            re = -re;
        }
        return re;
    }

    public static int myAtoi1(String str) {
        /*先找出字符串中第一个数字或+，-
        若找到后以该位置为起始位置向后遍历，直至非数字

        若字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符 返回0
        */
        int start = 0;
        int end = 0;
        int flag = 0;
        boolean ispos = true;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '&& (str.charAt(i)!='+'&&str.charAt(i)!='-') && (str.charAt(i)<'0' || str.charAt(i)>'9')&&flag==0){
                return 0;
            }
            if((str.charAt(i)=='+'||str.charAt(i)=='-') && (str.charAt(i)>='0' && str.charAt(i)<='9')) {
                if(str.charAt(start)=='-'){
                    ispos = false;
                }
            }
            if((str.charAt(i)>='0' && str.charAt(i)<='9') && flag==0){
                start = i;
                flag = -1;
            }
            if( (str.charAt(i)!='+'&&str.charAt(i)!='-')&&(str.charAt(i)<'0' || str.charAt(i)>'9') && flag ==-1 ){
                //继续向下遍历直至遇到非数字
                end = i;
                break;
            }
        }
        //通过判断start和end的大小可以知道是否有数字
        if(start == end && flag == 0){
            //这种情况只能是start=end=0 说明字符串中无数字
            return 0;
        }
        //其他情况说明一定存在数字
        if(end == 0){
            //end为0说明一直到有效数字一直到字符串结尾才结束
            end = str.length();
        }
        //判断数字第一位是否为+或-，若是则从第二位开始计算
        if(str.charAt(start)=='+'||str.charAt(start)=='-'){
            if(str.charAt(start)=='-'){
                ispos = false;
            }
            start = start+1;
        }
        //然后end-start+1可以算出有几位数
        int digit = end - start;
        int num = 0;
        for (int i = start; i < end; i++) {
            num += (str.charAt(i)-'0')*Math.pow(10,digit-1);
            digit--;
        }
        if(!ispos){
            num = num*-1;
        }
        if(num <= Math.pow(-2,31)+1){
            return (int)Math.pow(-2,31);
        }
        if(num >= Math.pow(2,31)-1){
            return (int)Math.pow(2,31)-1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("3.14159"));
    }
}
