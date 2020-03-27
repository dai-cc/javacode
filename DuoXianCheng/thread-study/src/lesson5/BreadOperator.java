package lesson5;

public class BreadOperator {
    //库存面包数量：上限100，下限0
    public static volatile int SUM;//面包总数

    public static void main(String[] args) {
        //启动五个生产者线程，生产面包
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(),"面包师傅"+i).start();
        }
        //启动消费者线程，消费面包
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(),"消费者"+i).start();
        }

    }

    //默认生产者：面包师傅生产面包：默认一次生产3个面包
    private static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    synchronized (BreadOperator.class) {
                        //此时生产完之后库存达到100上限，是不行的，多以库存在97以上就不能生产
                        if (SUM + 3 > 100) {
                            //释放对象锁，需要让其他线程进入同步代码块，当前线程需要进入阻塞状态
                            BreadOperator.class.wait();
                        }
                        SUM += 3;//生产面包
                        Thread.sleep(10);
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName()+",生产了，库存为："+SUM);
                    }
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //默认消费者：消费面包，默认一次消费一个面包
    private static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (BreadOperator.class) {
                        //库存为0，不能继续消费，阻塞当前线程（不能继续消费）
                        if(SUM == 0){
                            BreadOperator.class.wait();
                        }
                        SUM--;
                        Thread.sleep(10);
                        //notify和notifyAll：两个都是通知调用wait()被阻塞的线程
                        //但是notify是随机选一个wait方法阻塞的线程唤醒，而notifyAll是唤醒全部被wait阻塞的线程
                        //在synchronized代码块结束之后才会唤醒，也就是释放对象锁之后才会唤醒
                        //等于说synchronized结束之后wait和synchronized代码行阻塞的线程都会被唤醒
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName()+",消费了，库存为："+SUM);
                    }
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
