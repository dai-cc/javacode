import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: will
 * @Date: 2020/3/20
 * @description:
 */


// 为了实现简单，假设优先级队列中放置int
// 假设：实现一个小堆

/*
 因为代码中比较的方式写死了，是按照小于的方式比较的，因此最后肯定是小堆
 如果想要进行大小堆的选择：底层比较方式就不能写死

 如何支持让用户选择选择大小堆？
 不要将元素比较写死，让用户提供比较方式
 */

interface Comp
{
    public int compare(int left, int right);
}

// 按照小于的方式进行比较
class Less implements Comp{
    // 0: left == right
    // > 0: left > right
    // < 0: left < right
    public int compare(int left, int right){
        return  left - right;
    }
}

class Greater implements Comp{
    public int compare(int left, int right){

        return  right - left;
    }
}



public class MyPriorityQueue {
    private int[] array;
    int size = 0;  // 不能用array.length表示有效元素的个数，因为length表示数组的大小
    Comp compare = null;

    public MyPriorityQueue(Comp com){
        // 默认的构造----将其底层容量设置为11
        array = new int[11];
        compare = com;
    }

    public MyPriorityQueue(int initCapacity, Comp com)
    {
        if(initCapacity < 1){
            // 标准库：抛出一个非法参数的异常
            initCapacity = 11;
        }

        array = new int[initCapacity];
        compare = com;
    }

    // 注意：标准库中没有该接口---标准库中可以采用集合来构造优先级队列
    public MyPriorityQueue(int[] arr, Comp com){
        // 有么有更好的方式将arr中的元素放置到array中？？？
        array = new int[arr.length];

        for(int i = 0; i < arr.length; ++i){
            array[i] = arr[i];
        }

        size = arr.length;
        compare = com;

        // 将array中的元素调整，让其满足小堆的性质
        // 找倒数第一个非叶子节点
        int lastLeaf = (array.length-2)>>1;
        for(int root = lastLeaf; root >= 0; root--){
            shiftDown(root);
        }
    }

    // 获取堆顶元素
    int peek(){
        // 标准库中，如果优先级队列是空，无法获取堆顶元素，因此返回null
        return array[0];
    }

    boolean offer(int x){
        // 0. 检测是否需要扩容
        grow();
        // 1. 先将元素尾插到数组中
        array[size++] = x;

        // 2. 检测新元素插入后释放破坏小堆的性质
        shiftUp(size-1);  // 注意：此处一定不能使用size--
        return  true;
    }

    // 删除：删除堆顶的元素
    int poll(){
        int ret = array[0];
        swap(0, size-1);
        size--;

        shiftDown(0);
        return ret;
    }

    boolean isEmpty(){
        return 0 == size;
    }

    int size(){
        return size;
    }

    void clear(){
        size = 0;
    }

    // parent表示本次需要调整的节点的小标
    // 调整以parent为根的二叉树
    // 注意：调整之前，一定要保证parent的左右子树已经满足小堆的性质
    // 如果要检测parent是否满足小堆的性质，只需要使用parent与其孩子进行比较
    // 满足小堆性质--->说明以parent为根的二叉树已经是小堆
    // 不满足小堆性质--->说明parent比其孩子大，此时需要将parent与其较小的孩子进行交换
    //                  交换完以后，parent交大的元素向下移动，可能导致其子树不满足小堆的性质
    //                  需要继续调整其子树
    private void shiftDown(int parent){
        // 使用child标记parent的较小的孩子
        // 默认情况下先让其标记左孩子，因为parent可能有左孩子但是没有右孩子
        int child = parent*2+1;

        while(child < size){
            // 找parent中较小的孩子
            // 在用左右孩子比较时，必须要保证右孩子存在--while循环条件已经保证左孩子存在
            //if(child+1 < size && array[child+1] < array[child]){
            if(child+1 < size && compare.compare(array[child+1], array[child]) < 0){
                child += 1;
            }

            // 检测较小的孩子是否比双亲小
            //if(array[child] < array[parent]){
              if(compare.compare(array[child], array[parent]) < 0){
                // 说明parent不满住小堆的性质--将parent与child进行交换
                swap(parent, child);

                // parent交大的元素向下移动可能会导致子树不满足对的性质
                // 继续向下调整
                parent = child;
                child = parent*2+1;
            }
            else{
                // 以parent为根二叉树已经满足堆的性质
                return;
            }
        }
    }

    // 2*6*4*2=96
    private void shiftUp(int child){
        int parent = (child-1)>>1;

        while(child != 0){
            //if(array[child] < array[parent]){
            if(compare.compare(array[child], array[parent]) < 0){
                swap(child, parent);

                child = parent;
                parent = (child-1)>>1;
            }
            else{
                return;
            }

        }
    }

    //扩容---参考顺序表
    // 只是模拟标准库中优先级队列扩容的一部分
    private void grow(){
        if(size >= array.length){
            int oldCapacity = array.length;
            int newCapacity = oldCapacity + ((oldCapacity < 64)? (oldCapacity+2):(oldCapacity>>1));
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    private void swap(int parent, int child){
        int temp = array[parent];
        array[parent] = array[child];
        array[child] = temp;
    }

    public static void main(String[] args) {
        int array[] = {5,3,7,1,4,6,8,0,2};

        MyPriorityQueue mp = new MyPriorityQueue(array, new Less());
        mp.offer(9);
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.offer(-1);
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.poll();
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.clear();
        if(mp.isEmpty()){
            System.out.println("空");
        }
        else{
            System.out.println("非空");
        }
    }
}
