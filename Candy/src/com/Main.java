package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int aSubB = sc.nextInt();
            int bSubC = sc.nextInt();
            int aPlusB = sc.nextInt();
            int bPlusC = sc.nextInt();

            int b = (aSubB-bSubC-aPlusB-bPlusC)/(-4);
            int a = ((aSubB+bSubC+aPlusB+bPlusC)-2*b)/2;
            int c = (bSubC-bPlusC)/(-2);

            if((a-b==aSubB) &&(b-c == bSubC) &&(a + b == aPlusB) && (b + c ==bPlusC)){
                System.out.print(a+" ");
                System.out.print(b+" ");
                System.out.print(c);
            }else{
                System.out.println("No");
            }
        }
    }
}
