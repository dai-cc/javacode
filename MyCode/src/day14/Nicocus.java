package day15;

import java.util.Scanner;

/*
* 验证尼克彻斯原理
* 任何一个整数m的立方都可以写成m个连续技术之和
* 1^3=1
* 2^3=3+5
* 3^3=7+9+11
* 4^3=13+15+17*/
public class Nicocus {
    public static String GetSequeOddNum(int m){
        //n = (1+2+3+。。。+(m-1))*2+1
        //= ((1+(m-1))*(m-1))/2*2+1;
        //= ((1+(m-1))*(m-1))+1;
        //((1+(m-1))*(m-1))/2 等差数列前n项和
        int n = ((1+(m-1))*(m-1))+1;
        //m的立方= n+(n+2)+(n+4)...+(n+2*(m-1))
        int an = n+2*(m-1);
        StringBuffer sb = new StringBuffer();
        while(n != an){
            sb.append(n);
            sb.append("+");
            n += 2;
        }
        sb.append(n);
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            System.out.println(GetSequeOddNum(m));
        }
    }
}
