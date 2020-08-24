package day0824;

/*
* 大家都知道斐波那契数列，现在要求输入一个整数n，
* 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n<=39
* */
public class Fibonacci {
    public static int Fibonacci(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n+1; i++) {
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(0));
    }
}
