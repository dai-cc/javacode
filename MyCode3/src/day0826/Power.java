package day0826;

/*
给定一个double类型的浮点数base和int类型的整数exponent。
求base的exponent次方。
保证base和exponent不同时为0
*/
public class Power {
    public static double Power(double base, int exponent) {
        double ret = 1;
        if(exponent < 0){
            base = 1/base;
            exponent = -exponent;
        }
        while (exponent != 0){
            ret *= base;
            exponent--;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Power(2,-3));
    }
}