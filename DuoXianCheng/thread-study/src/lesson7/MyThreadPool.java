package lesson7;

import lesson2.MyThread;
import lesson6.MyBlockingQueue;

public class MyThreadPool {
    private MyBlockingQueue<Runnable> queue;

    public MyThreadPool(int size, int capacity){
        queue = new MyBlockingQueue<>(capacity);
        //创建正式员工
        for (int i = 0; i < size; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //让正式员工一直运行
                        while(true){
                            //从仓库取包裹：
                            // 情况1. 成功取出包裹（任务），方法返回
                            // 情况2. 仓库里取不出报错（其他元素正在取，阻塞在synchronized代码行，或是仓库没有包裹，在wait方法阻塞）
                            Runnable task = queue.take();
                            // 正式员工来送快递（当前线程通过实例方法调用来执行任务）
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(5,100);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("C");
            }
        });
    }
}
