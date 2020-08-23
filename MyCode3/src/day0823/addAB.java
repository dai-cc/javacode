package day0823;

public class addAB {
    public static int Add(int num1,int num2) {
        /*
        1. 两个数异或：相当于每一位相加，而不考虑进位，得到结果sum
        2. 两个数相与，并左移一位：相当于求得进位，得到jinwei
        3. 由于sum+jinwei也要通过上述两部进行计算，可能会产生借位，所以此时应该是一个循环
        4. 每次计算完后新的num1为sum，新的num2为jinwei
        5. 直到进位为0时运算结束返回sum
        */
        int sum = 0;
        int jinwei = -1;
        while (jinwei != 0){
            sum = num1 ^ num2;
            jinwei = (num1 & num2) << 1;
            num1 = sum;
            num2 = jinwei;
        }
        return sum;
    }
    public static void main(String[] args) {
        /*不用+，-，*，/四则运算求两个整数之和*/
        int a = 10;
        int b = 20;
        System.out.println(Add(a,b));
    }
}
