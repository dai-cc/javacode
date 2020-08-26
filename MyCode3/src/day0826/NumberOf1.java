package day0826;
/*
* 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
* */
public class NumberOf1 {
    // 方法1：暴力解法
    public int NumberOf1(int n) {
        int ans = 0;
        while (n != 0){
            ans += (n&1);
            n = n >>> 1;// 此处要用无符号右移，无符号右移不管数字正负都是补0
        }
        return ans;
    }
    // 方法2：技巧法
    // 比如给定整数n：11011，n-1:11010 , n&(n-1):11010
    // 观察结果可以发现n&(n-1)结果就是将最右边那个1消掉了
    // 所以二进制中有几个1，这个运算就可以进行几次
    public int NumberOfOne(int n) {
        int ans = 0;
        while (n != 0){
            n &= (n-1);
            ans++;
        }
        return ans;
    }
}