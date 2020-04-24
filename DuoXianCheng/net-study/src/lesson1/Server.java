package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.out;

public class Server {
    private static final int PORT = 9000;

    private static final ExecutorService POOL = Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        //处理多个客户端
        while(true){
            //阻塞等待，直到有新的客户端连接
            // 为了不让他影响main线程，创建一个新线程
            Socket client = server.accept();//这是一个阻塞式方法，所以最好是启动新的线程来做

            POOL.execute(new Task(client));
        }

    }
    //写一个静态内部类，处理客户端的Socket对象IO流数据的处理
    private static class Task implements Runnable{

        private Socket client;
        public Task(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            try {
                //将读取的数据流转化为BufferedReader,处理更高效
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                //这样的话每次都要重新flush一下发送出去
                //PrintWriter pw = new PrintWriter(client.getOutputStream())
                //为了不让他每次都自动flush一下，采用
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                String str;
                int i = 1;
                while((str = in.readLine()) != null ){
                    System.out.println(str);
                    out.println(i+"确实厉害");
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
