package lesson4;

public class SafeThread {
    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private static int SUM;

    public static void main(String[] args) {
        //同时启动20个线程，
        // 每个线程对同一个变量执行循环10000次每次循环++操作
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                        //increment();
                     /*   synchronized (this){
                            //同步代码块，后面需要有个小括号传对象
                            //因为这个地方是在run方法中的this所以这个this指的是runnable对象
                            //加在runnable上无法避免线程安全问题，只是给自己线程内部加锁，对其他线程没有影响
                        }*/
                        synchronized (SafeThread.class){
                            SUM++;
                        }
                    }
                }
            }).start();
        }
        //等待开启的20个子线程全部执行完
        while(Thread.activeCount()>1){//注意用debug执行
            Thread.yield();
        }

        System.out.println(SUM);
    }
    public static synchronized void increment(){
        //同步静态方法
        SUM++;
    }
}

