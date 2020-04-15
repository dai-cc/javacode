package day15;

import java.util.Scanner;

public class UnusualAdd {
    public static int addAB(int A, int B) {
        // write code here
        int sum = A ^ B;//无进位相加
        int fla = A & B;//同为1的情况，即需要进位的地方
        while(fla != 0){
            fla = fla<<1;
            int s = sum;
            sum ^= (fla);
            fla &= s;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(addAB(A,B));
        }
    }
}
