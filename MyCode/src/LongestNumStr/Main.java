package LongestNumStr;

import java.util.Scanner;

/*
* 读入一个字符串str，输出字符串中的连续最长数字串
* */
public class Main {

    public static void main(String[] args) {
        //遍历字符串，开辟一个数组记录数字串的起始位置和终止位置，
        //字符串的偶数位是起始位置，奇数位是终止位置，然后两两相减，比较谁大
        //最后返回最大的结果 subString(i,j)
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.nextLine();
            int max = 0;
            int count = 0;
            int end = 0;

            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    count++;
                    //退出while说明此时已经不是数字了，判断此时数字串长度和maxlen大小
                    if(max < count){
                        max = count;
                        end = i;
                    }
                }else{
                    count = 0;
                }

            }
            System.out.println(str.substring(end-max+1,end+1));
        }
    }
}
