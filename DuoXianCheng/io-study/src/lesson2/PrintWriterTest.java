package lesson2;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class PrintWriterTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(sc.nextInt()==0){
                        throw  new RuntimeException("i==0");
                    }
                    System.out.println();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    //涉及到一种设计模式：适配器模式
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    e.printStackTrace(pw);
                    String stackTrace = sw.toString();
                    System.err.println(stackTrace);//通过err打印就是红色的
                }
            }
        }).start();
    }
}
