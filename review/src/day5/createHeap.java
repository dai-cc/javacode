package day5;

public class createHeap {
    public static void shiftDown(int[] array, int parent) {
        // child先标记parent的左孩子，因为parent可能右左没有右
        int child = 2 * parent + 1;

        while (child < array.length) {

            // 如果右孩子存在，找到左右孩子中较小的孩子,用child进行标记
            if(child+1 < array.length&& array[child+1] < array[child]){
                child += 1;
            }

            //
            if (array[parent] > array[child]) {
                // 将双亲与较小的孩子交换
                int temp = array[parent];
                array[parent] = array[child];
                array[child] = temp;

                // parent中大的元素往下移动，可能会造成子树不满足堆的性质，因此需要继续向下调整
                parent = child;
                child = parent * 2 + 1;
            }else{
                break;
            }
        }
    }
    public static void createHeap(int[] array) {
        // 找倒数第一个非叶子节点，从该节点位置开始往前一直到根节点，遇到一个节点，应用向下调整
        int root = ((array.length-2)>>1);
        for (; root >= 0; root--) {
            shiftDown(array, root);
        }
    }

    // 堆的插入（按小堆）
    public void shiftUp(int[] array,int child) {
        // 找到child的双亲
        int parent = (child - 1) / 2;

        while (child > 0) {
            // 如果双亲比孩子大，parent满足堆的性质，调整结束
            if (array[parent] > array[child]) {
                break;
            }
            else{
                // 将双亲与孩子节点进行交换
                int t = array[parent];
                array[parent] = array[child];
                array[child] = t;

                // 小的元素向下移动，可能到值子树不满足堆的性质，因此需要继续向上调增
                child = parent;
                parent = (child - 1) / 1;
            }
        }
    }
}

