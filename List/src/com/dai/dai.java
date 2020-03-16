/*
* 顺序表
* */
public class dai {
    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(2,8);
    }
}

class MyArrayList {
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法
        if (pos <= this.usedSize && pos >= 0) {
            throw new IndexOutOfBoundsException("pos位置不合法");
            //或者直接return;
        }

        //2、挪数据
        //3、插入数据
        //4、usedSize++
       /*if(pos<=this.usedSize && pos>=0) {
           elem[usedSize] = elem[usedSize - 1];
           elem[usedSize - 1] = elem[usedSize - 2];
           elem[pos] = data;
           usedSize++;

*//*           for (int x:elem) {
               System.out.println(x+" ");
           }
           System.out.println(usedSize);*//*
       }else if(pos>this.usedSize){
           this.usedSize=2*usedSize;
           this.elem=new int[CAPACITY*2];
           //System.arraycopy(arr,0,arr2,0,array.length);
       }
    }*/
    }
    public boolean contains(int toFind) {
        // 查找某个元素对应的位置
        for (int i = 0; i < this.elem.length; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }
    public int search(int toFind) {
        // 获取 pos 位置的元素

        return -1;
    }


    public void remove(int toRemove) {
   //删除第一次出现的关键字toRemove
        /*判断顺序表是否为空
        * 查找toRemove的下标
        * 删除i*/


        if(this.usedSize!=0){
            int flag=0;
            for (int i = 0; i < this.elem.length; i++) {
                if (toRemove == this.elem[i]) {
                  flag = i;
                }
            }
            for (int j = flag; j < this.usedSize-1; j++) {
                this.elem[j]=this.elem[j+1];
            }
            this.usedSize--;
        }else{
            System.out.println("顺序表为空");
            return;
        }
    }
}

    /*  // 判定是否包含某个元素
    public boolean contains(int toFind) { return true; }
    // 查找某个元素对应的位置
    public int search(int toFind) { return -1; }
    // 获取 pos 位置的元素
    public int getPos(int pos) { return -1; }
    // 给 pos 位置的元素设为 value
    // public void setPos(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int toRemove) { }
    // 获取顺序表长度
    public int size() { return 0; }
    // 清空顺序表
    public void clear() { }
    // 打印顺序表
    public void display() { }
}
*/

