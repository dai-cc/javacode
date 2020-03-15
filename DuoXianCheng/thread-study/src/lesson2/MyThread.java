package lesson2;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
class main{
    public static void main(String[] args) {
        Thread mythread = new MyThread();
        //mythread.start();
        mythread.run();

    }
}


class MyRunnable implements Runnable{
    @Override
    public void run() {

    }
}
