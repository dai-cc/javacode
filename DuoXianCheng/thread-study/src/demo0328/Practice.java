package demo0328;
/*
* 多线程编程：
* 启动3个线程，
* 第一个线程打印a，第二个线程打印b，第三个线程打印c，循环打印10次。
* 要求是，同时启动3个线程，但是打印结果是这样的
* abc
* abc
* abc
* ...
 */
public class Practice {
    private volatile static boolean AIsDone = false;
    private volatile static boolean BIsDone = false;
    private volatile static boolean CIsDone = true;

    private static class PrintA implements Runnable {
        @Override
        public void run() {
            synchronized (Practice.class) {
                while(!CIsDone) {
                    System.out.println("a");
                }
                AIsDone = true;
                notifyAll();
            }
        }
    }

    private static class PrintB implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (Practice.class) {
                    while (!AIsDone) {
                        Practice.class.wait();
                    }
                    BIsDone = true;
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static class PrintC implements Runnable {
        @Override
        public void run() {
                try {
                    synchronized (Practice.class) {
                        while (!BIsDone) {
                            Practice.class.wait();
                        }
                        notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintA());
        Thread threadB = new Thread(new PrintB());
        Thread threadC = new Thread(new PrintC());
        for (int i = 0; i < 10; i++) {
            threadA.start();
            threadB.start();
            threadC.start();
        }
    }
}
