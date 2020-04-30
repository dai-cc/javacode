package day27;

import java.util.HashMap;
import java.util.Scanner;
/*
* 输入一个数n，在输入n个各不相同的数字，再输入一个值x
* 输出x在数组中的下标（从0开始，若不在数组中则输出-1）*/
public class FindX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            HashMap<Integer,Integer> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hm.put(sc.nextInt(),i);
            }
           int x = sc.nextInt();
            System.out.println(hm.getOrDefault(x,-1));
        }
    }
}
