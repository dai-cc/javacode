package lesson2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorsService {

    //设置线程池的数量，可以根据单个任务量+主机配置+环境（系统中运行的其他程序）
    //单个主机运行的主任务是本程序的话，推荐的任务数量是根据处理器核数来决定
    //一般在处理器核核数基础上加减1，2，或者直接用处理器核数
    //获取处理器核数：
    private static int COUNT = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        //数量为1的固定大小的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //固定大小的线程池：给定正式员工的数量，没有临时工
        ExecutorService pool1 = Executors.newFixedThreadPool(4);
        //缓存的线程池：没有正式员工，全是临时工  类似于外包公司
        ExecutorService pool2 = Executors.newCachedThreadPool();
        //定时任务的线程池：有正式员工，也有临时工
        ExecutorService pool4 = Executors.newScheduledThreadPool(4);
    }
}
