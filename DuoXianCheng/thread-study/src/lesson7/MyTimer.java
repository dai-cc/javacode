package lesson7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTimer {
    /*定时任务
        task:需要执行的任务
        delay 从当前时间延迟多少毫秒，执行任务
        period 间隔时间：<=0就忽略掉，>0需要每间隔给定时间，就执行任务
    */

    public void schedule(Runnable task,long delay,long period) {
        long current = System.currentTimeMillis();
        try {
            Thread.sleep(delay);
            new Thread(task).start();
            while(period > 0){
                Thread.sleep(period);
                new Thread(task).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //JDK的时间操作
    public static void main(String[] args) {
        //Date的学习
        Date date1 = new Date();//无参的构造方法：返回系统当前时间
        Date date2 = new Date(9999);//以格林威治时间（1970-01-01）开始，经过给定时间数量的毫秒

        //DateFormat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//HH代表24进制，hh代表12进制
//        System.out.println(df.format(date1));
//        System.out.println(df.format(date2));

        //System类的一些时间获取:从19700101开始到当前时间点经过的毫秒数
        long current = System.currentTimeMillis();

//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("起床了");
//            }
//        };
//        new Timer().schedule(task,3000,1000);

//        new MyTimer().schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("起床了");
//            }
//        },3000,1000);

//        ExecutorService pool = Executors.newSingleThreadExecutor()
//      ExecutorService pool = Executors.newFixedThreadPool(4);
        ExecutorService pool = Executors.newScheduledThreadPool(4);
//        ExecutorService pool = Executors.newCachedThreadPool();




    }
}
