package lesson4;

public class VolatileTest2 {
    private volatile static int SUM;
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        if(SUM < 100000){
                            synchronized (VolatileTest2.class){

                                SUM++;
                            }
                        }
                    }
                }
            }).start();
        }
        while(Thread.activeCount()>1){//注意用debug执行
            Thread.yield();
        }
        System.out.println(SUM);
    }
}
