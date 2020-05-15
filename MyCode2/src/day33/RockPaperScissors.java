package day33;

import java.util.HashMap;
import java.util.Scanner;

/*
* 石头剪刀布
* 输出第一行N，给出双方交锋次数，随后N行，每行给出一次交锋信息
* C表示锤子，J表示剪刀，B表示布，第一个字母代表甲方，第二个代表一方
* 输出第一二行分别给出甲乙胜平负的次数
* 第三行给出两个字母，分别表示甲乙获胜次数最多的手势，
* 如果解不唯一，则输出按字母序最小的解*/
public class RockPaperScissors {
    private static String winMost(int[] arr){
        int max = arr[0];
        int n = 0;
        for (int i = 1; i < 3; i++) {
            if(max < arr[i]){
                max = arr[i];
                n = i;
            }
        }
        if(n == 0){
            return "B";
        }else if(n == 1){
            return "C";
        }else{
            return "J";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            //用哈希表存储甲乙赢得时候出的牌（key）以及赢得次数(value)
            HashMap<String,Integer> A = new HashMap<>();
            HashMap<String,Integer> B = new HashMap<>();
            int counta = 0;
            int countb = 0;
            int[] numa = new int[3];
            int[] numb = new int[3];
            int numbC=0,numbJ=0,numbB=0;

            for (int i = 0; i < N; i++) {
                String a = sc.next();
                String b = sc.next();

                if(a.equals("C")){
                    if(b.equals("J")){//a赢
                        A.put("C",A.getOrDefault("C",0)+1);
                        counta++;
                        numa[1]++;
                    }else if(b.equals("B")){//b赢
                        B.put("B",B.getOrDefault("B",0)+1);
                        countb++;
                        numb[0]++;
                    }
                }
                if(a.equals("J")){
                    if(b.equals("B")){//a赢
                        A.put("J",A.getOrDefault("J",0)+1);
                        counta++;
                        numa[2]++;
                    }else if(b.equals("C")){//b赢
                        B.put("C",B.getOrDefault("C",0)+1);
                        countb++;
                        numb[1]++;
                    }
                }
                if(a.equals("B")){
                    if(b.equals("C")){//a赢
                        A.put("B",A.getOrDefault("B",0)+1);
                        counta++;
                        numa[0]++;
                    }else if(b.equals("J")){//b赢
                        B.put("J",B.getOrDefault("J",0)+1);
                        countb++;
                        numb[2]++;
                    }
                }
            }
            //统计完之后
            System.out.println(counta +" " + (N-counta-countb) +" "+ countb);
            System.out.println(countb +" " + (N-counta-countb) +" "+ counta);
            //还要输出A B赢得最多的手势

            System.out.print(winMost(numa) + " " + winMost(numb));
        }
    }
}
