package lesson3;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class InterruptThread {
    //中断一个线程，但是线程没有进行中断
    public static void test1() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        });
        t.start();
        t.interrupt();
    }

    public static void test2() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //线程运行状态时，需要自行判断运行中断标志位，然后处理中断是否往下执行
//                for (int i = 0; i < 50; i++) {
//                    System.out.println(i + "=" +Thread.currentThread().isInterrupted());
//                }
               //while(Thread.interrupted()){
               while(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        t.start();//此时Thread-0线程没有被中断，标志位位false
        t.interrupt();//t线程中的中断标志位=true
    }

    public static void test3() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().isInterrupted());//true
                    //线程处于调用wait()/join()/sleep()方法进入阻塞时，
                    // 如果把当前线程中断，会直接抛异常
                    //阻塞状态时，通过捕获及处理异常，来处理线程的中断逻辑
                    //抛出异常之后线程的中断标志位会进行重置
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().isInterrupted());//false
                }
            }
        });
        t.start();//此时Thread-0线程没有被中断，标志位位false
        t.interrupt();//t线程中的中断标志位=true
    }

    public static void test4() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //System.out.println(Thread.interrupted());
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t.start();//此时Thread-0线程没有被中断，标志位位false
        t.interrupt();//t线程中的中断标志位=true
    }

    private static volatile boolean IS_INTERRUPTED;
    public static void test5() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //运行态的时候可以
//               while(!IS_INTERRUPTED){
//                   System.out.println(Thread.currentThread().getName());
//               }
                //此处并没有抛出异常
                //说明自定义的标志为满足不了线程处于阻塞态时的终端操作
                try {
                    Thread.sleep(99999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        IS_INTERRUPTED = true;
    }

    public static void main(String[] args) {
       //test1();
        //test2();
        //test3();
        test4();
    }
}
