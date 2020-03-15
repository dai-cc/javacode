package review;

import org.junit.Test;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(sc.next());
        }

//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            System.out.println(sc.nextLine());
//        }

        // 第一行是一个数字n，第二行有n个数字，以空格间隔
        // 例如：第一行4，第二行2 4 1 3
//        Scanner sc = new Scanner(System.in);
//        int count = sc.nextInt();
//        for(int i=0; i<count; i++){
//            int num = sc.nextInt();
//        }
    }

}
