package lesson2;

public class ThreadYield {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //等待new Thread所有线程执行完毕，否则一直等待
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
