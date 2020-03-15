package lesson2;
/*
*   创建一个守护线程，看守护线程和其他线程的区别
*/
public class DaemonThread {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);//将该线程设置成守护线程
        t.start();
    }
}
