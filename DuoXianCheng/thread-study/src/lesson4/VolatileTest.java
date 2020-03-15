package lesson4;

public class VolatileTest {
    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private volatile static int SUM;

    public static void main(String[] args) {
        //同时启动20个线程，
        // 每个线程对同一个变量执行循环10000次每次循环++操作
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                            SUM++;
                            //SUM++分解为三条指令
                            //1. 读取主内存中的SUM变量
                            //2. SUM=SUM+1
                            //3. 写回主内存
                            //加了volatile之后也无法保证原子性，这三条指令执行途中可能会有其他指令执行
                            //volatile不能满足原子性，所以不能满足n++,n--操作的线程安全
                            //volatile对变量进行赋值操作时，需要是常量（即不能依赖共享变量）
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

}
