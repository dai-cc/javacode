package lesson2;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        //想让程序先将t线程执行完毕再往下执行
        t.join();
        System.out.println(Thread.currentThread().getName());
    }
}
