package lesson5;

public class Sington {
    private static volatile Sington SINGTON;
    //假设不适用volatile，但是能保证变量的可见性，会出现问题吗？
    //也就是说不保证重排序不出现什么问题
    public static Sington newInstance() {
        if(SINGTON == null){//提高效率，变量使用volatile可以保证可见性
            synchronized (Sington.class){
                //为了保证单例模式，返回的是同一个对象
                if(SINGTON == null) {
                    //new对象会分解三条指令
                    //分配内存空间，初始化对象，将new好的对象赋值给变量
                    SINGTON = new Sington();
                }
            }

        }
        return SINGTON;
    }
}

