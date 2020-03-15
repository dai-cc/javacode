package lesson3;

public class UnsafeThread {
    static int num = 0;
    public static void main(String[] args) {
        //同时启动20个线程，
        // 每个线程对同一个变量执行循环10000次每次循环++操作
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                       num++;
                    }
                }
            }).start();
        }
        //等待开启的20个子线程全部执行完
        while(Thread.activeCount()>1){//注意用debug执行
            Thread.yield();
        }
        //1.不是预期的结果200000
        //2.每次运行的结果不一样
        System.out.println(num);
    }
}
