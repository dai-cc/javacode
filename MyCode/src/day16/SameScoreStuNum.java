package day16;

import java.util.HashMap;
import java.util.Scanner;

public class SameScoreStuNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            if(N == 0){
                break;
            }
            int[] arr = new int[N];
            HashMap<Integer,Integer> hm = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            }
            int score = sc.nextInt();
            System.out.println(hm.getOrDefault(score,0));

        }
    }
}
