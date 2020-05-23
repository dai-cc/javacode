package day40;

import java.util.Scanner;

/*
* 句子逆序
* 将英语语句以单词为单位逆序排放
* 原：I am a boy
* 改：boy a am I
*/
public class SentenceReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] sentence = s.split(" ");
            for (int i = sentence.length-1; i >= 0; i--) {
                System.out.print(sentence[i]);
                if(i != 0){
                    System.out.print(" ");
                }
            }
        }
    }
}
