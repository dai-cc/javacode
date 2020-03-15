package lesson2;

public class Advantage {
    private static final int NUM = 2;

    private static void increment(){
        int count = 10_0000_0000;
        int r = 0;
        for (int i = 0; i < count; i++) {
            r++;
        }
    }

    //定义一个串行的方法(代码依次执行)
    private static void serial(){
        long start = System.currentTimeMillis();//1970-01-01开始，到当前时间的毫秒数
        for (int i = 0; i < NUM; i++) {
            increment();
        }
        long end = System.currentTimeMillis();
        System.out.printf("串行执行时间：%s毫秒\n", end-start);
    }

    //并发(有时候Java语义中，并发既表达并发也表达并行)
    private static void parallel(){
        long start = System.currentTimeMillis();//1970-01-01开始，到当前时间的毫秒数
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            }).start();
        }
        //等待以上new Thread所有线程执行完毕，否则一直等待
        while(Thread.activeCount()>1){
            Thread.yield();
            //如果活跃线程数大于1，那么让当前线程让步
        }
        //并发过程中不在一个线程中执行，所以可能执行到long end = System.currentTimeMillis();的时候thread线程不一定结束，所以要把线程结束之后再计算时间
        long end = System.currentTimeMillis();
        System.out.printf("并发执行时间：%s毫秒\n", end-start);

    }
    public static void main(String[] args) {
        serial();
        parallel();
    }
}
