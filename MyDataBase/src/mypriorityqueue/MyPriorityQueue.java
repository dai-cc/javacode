package mypriorityqueue;

interface Comp{
    public int compare(int left,int right);
}

class Less implements Comp{
    //0:left == right
    //>0:left > right
    //<0:left < right
    public int compare(int left,int right){
        return left - right;
        Integer
    }
}
class Great implements Comp{
    public int compare(int left,int right){
        return right - left;
    }
}
//为了实现简单，假设优先级队列中存放的是int类型的元素
public class MyPriorityQueue {
    private int[] array;
    int size = 0;//注意不能用array.length表示有效元素个数，因为他表示的是有效元素的大小
    Comp compare = null;
    public MyPriorityQueue(Comp com){
        //默认构造方法底层容量设置为11
        array = new int[11];
        compare = com;
    }
    public MyPriorityQueue(int initCapacity,Comp com){
        if(initCapacity<1){
            //标准库里是抛出非法参数异常
            initCapacity = 11;
        }
        array = new int[initCapacity];
        compare = com;
    }
    //注意标准库中没有该接口，标准库中采用的是集合来构造优先级队列
    public MyPriorityQueue(int[] arr,Comp com){
        //可以通过其他更好的方式将arr中的元素放置到数组中
        array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        //将arr中的元素调整满足小堆的性质
        //找倒数第一个非叶子节点
        int lastNotLeaf = (array.length - 2)>>1;
        for (int root = lastNotLeaf; root >=0 ; root--) {
            shiftDown(root);
        }
        compare = com;
    }

    //parent表示本次需要调整的节点下标
    //调整以parent为根的二叉树
    //注意调整之前要保证parent的左右子树已经满足小堆的性质
    private void shiftDown(int parent){
        //使用child标记parent的较小孩子
        //默认情况下让其标记左孩子，因为可能没有右孩子
        int child = parent * 2 + 1;//用child标记parent的左孩子
        int size = array.length;
        while(child < size){
            //找parent中较小孩子
            //if(child+1 < size && array[child + 1] < array[child]){
            if(child+1 < size && compare.compare(array[child + 1],array[child])<0){
                //右孩子比左孩子大
                child = child + 1;
            }
            //检测较小孩子是否比双亲小
            //if(array[child] < array[parent]){
            if(compare.compare(array[child],array[parent])<0){
                //说明双亲不满足小堆的性质
                swap(parent,child);
                parent = child;
                child = parent * 2 + 1;
            }else{
                //以parent为根的二叉树已经满足堆的性质
                return;
            }
        }
    }

    private void swap(int parent,int child){
        int temp = array[parent];
        array[parent] = array[child];
        array[child] = temp;
    }

    //获取堆顶元素
    public int peek(){
        //标准库里面如果优先级队列为空，返回的是Null
        return array[0];
    }

    public boolean offer(int x){
        //先将元素放到底层数组当中
        array[size+1] = x;
        //检测新插入的元素是否破坏了堆的性质
        //将新插入的孩子和双亲进行比较
        return true;
    }
    void shiftUp(int child){}

    public int poll(){return 0;}
    public boolean isEmpty(){
        return size==0;
    }


}
