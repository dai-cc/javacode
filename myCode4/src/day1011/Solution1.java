package day1011;

import java.util.Scanner;

public class Solution1 {
    private static int frog(int n){
        if(n == 0 || n == 1 || n == 2){
            return n;
        }else {
            return frog(n-1)+frog(n-2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(frog(n));
        }
    }
}
