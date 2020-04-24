package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class Client {
    //需要客户端绑定某一台主机,所以指定
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9000;

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(HOST,PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //PrintWriter和BufferedWriter都可以用
        //只是PrintWriter可以按行输出方便一点
        //而BufferedWriter需要输入\n来换行
        PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        Scanner scanner = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String line = scanner.nextLine();
                out.println("line");
            }
        }).start();



        String str;
        while((str = in.readLine()) != null){
            System.out.println(str);
        }
        out.println("我算法很厉害");


    }
}
