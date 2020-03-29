package lesson6;

/*
* 实现阻塞式队列：
* 1. 满足线程安全的生产，消费功能
* 2. 生产，消费达到上限/下限时，需要阻塞等待
* */
public class MyBlockingQueue<E> {
    private Object[] items;

    private int takeIndex;//记录弹出位置的索引
    private int putIndex;//记录添加元素的索引
    private int size;

    public MyBlockingQueue(int capacity) {
        items = new Object[capacity];

    }

    //添加元素的操作
    public synchronized void put(E e) throws InterruptedException{
        while(size == items.length){
            wait();
        }
        //因为是循环队列，防止数组越界，所以+1操作之后取模
        putIndex = (putIndex + 1) % items.length;
        //存放元素
        items[putIndex] = e;
        size++;
        notifyAll();
    }

    //弹出元素的操作
    public synchronized E take() throws InterruptedException {
        //达到下限，需要等待
        while (size == 0){
            wait();
        }
        takeIndex = (takeIndex + 1) % items.length;
        notifyAll();
        size--;
        return (E)items[takeIndex];
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 100; j++) {
                            queue.put(k*100+j);
                            //此处为什么用i会报错，因为这里是一个匿名内部类
                            //不可以直接使用外部的变量，如果要用的话只能用final类型的
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        while(true){
            int num = queue.take();
            System.out.println(num);
        }
    }

}
