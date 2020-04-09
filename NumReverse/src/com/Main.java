package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            String str = ""+num;
            for (int i = str.length()-1; i >= 0; i--) {
                System.out.print(str.charAt(i));
            }
        }
    }
}
