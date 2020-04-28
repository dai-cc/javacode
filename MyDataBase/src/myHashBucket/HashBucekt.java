package myHashBucket;
/*
* 哈希桶--数组+链表
* 数组：可以帮助用户定位要将元素插入到哪个链表（组织链表）
* 数组中存储的元素实际为节点的引用
* 假设哈希桶中的key唯一*/
public class HashBucekt {
    public static class Node {
        int key;
        int value;
        Node next;
        Node(int Key,int value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    //给出哈希桶中的成员数据
    Node[] table;
    int capacity;//表格的容量---桶的个数
    int size;//有效元素的个数
    //设置一个负载因子
    double loadFact = 0.75;
    public HashBucekt(int initCap){
        // 保证哈希桶初始容量至少为十个
        capacity = initCap;
        if(initCap < 10){
            capacity = 10;
        }
        table = new Node[capacity];
        size = 0;
    }
    //插入
    public int put(int key,int value){
        resize();
        // 1. 通过哈希函数计算key所在的桶号
        int bucketNo = hashFunc(key);
        // 2. 在bucketNo桶中检测key是否存在
        //检测方式：遍历链表
        Node cur = table[bucketNo];
        while(null != cur){
            if(cur.key == key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
            cur = cur.next;
        }
        //说明key不存在，将key-value插入到哈希桶中
        cur = new Node(key,value);
        cur.next = table[bucketNo];
        table[bucketNo] = cur;
        size++;
        return value;
    }

    //删除哈希桶中为key的键值对删掉
    public boolean remove(int key){
        // 1. 通过哈希函数计算key的桶号
        int bucketNo = hashFunc(key);
        // 2. 在bucketNo桶中找到key对应的节点
        //找到后删除
        Node cur = table[bucketNo];
        Node pre = null;
        while(null != cur){
            if(cur.key == key){
                //找到并删除
                //注意分情况，看找到的节点是否为头结点
                if(pre == null){
                    //删除的节点刚好是第一个节点
                    table[bucketNo] = cur.next;
                }else{
                    //删除的是其他节点
                    pre.next = cur.next;
                }
                --size;
                return true;
            }else{
                cur = cur.next;
            }
        }
        return false;
    }
    //判断是否包含key
    public boolean containsKey(int key){
        // 1. 通过哈希函数计算key的桶号
        int bucketNo = hashFunc(key);
        // 2. 在bucketNo桶中找到key对应的节点
        //找到后删除
        Node cur = table[bucketNo];
        while(null != cur){
            if(cur.key == key){
                return true;
            }else{
                cur = cur.next;
            }
        }
        return false;
    }
    
    //判断是否包含value
    public boolean containsValue(int value){
        //注意哈希桶是根据key来计算哈希地址的
        //因此找value不能计算出value在哪个同
        //所以找value必须要遍历所有桶
        for (int bucketNo = 0; bucketNo < capacity; bucketNo++) {
            Node cur = table[bucketNo];
            while(null != cur){
                if(cur.value == value){
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }
    private void resize(){
        //转载因子超过0.75时进行扩容
        //按照两倍的方式进行扩容
        //8/10=0，永远不会>0.75,所以两边同乘10
        if(size*10/capacity > loadFact*10){
            Node[] newTable = new Node[capacity*2];
            int newCap = capacity*2;
            //将table中的节点搬移到newTable中
            for (int i = 0; i < capacity; i++) {
                Node cur = table[i];
                // 将table中i号桶所对应链表中所有的节点插入到newTable中
                while(null != cur){
                    table[i] = cur.next;

                    //将cur节点插入到newTable中
                    //1. 计算cur在newTable中的桶号
                    //int bucketNo = hashFunc(cur.key);不行
                    //因为hashFunc里面用的是旧容量的大小
                    int bucketNo = cur.key % newCap;
                    // 2. 将cur插入到newTable中
                    newTable[bucketNo] = cur;

                    //取table中i号桶的下一个节点
                    cur = table[i];
                }
            }

            table = newTable;
            capacity = newCap;
        }
    }
    //哈希函数
    private int hashFunc(int key){
        return key%capacity;
    }

    public void printHashBucket(){
        for (int bucketNo = 0; bucketNo < capacity; bucketNo++) {
            System.out.printf("table[%d]",bucketNo);
            Node cur = table[bucketNo];
            while(null != cur){
                System.out.print("[" + cur.key + "," + cur.value +"]");
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        HashBucekt ht = new HashBucekt(5);
        ht.put(1,1);
        ht.put(2,2);
        ht.put(3,3);
        ht.put(4,4);
        ht.put(14,14);
        ht.put(16,16);
        ht.put(21,21);
        ht.put(13,13);
        System.out.println(ht.size);
        ht.printHashBucket();
        ht.put(5,5);
        ht.printHashBucket();
        System.out.println(ht.containsKey(5));
        System.out.println(ht.containsKey(55));
        System.out.println(ht.containsValue(4));
        ht.remove(5);
        System.out.println(ht.containsKey(5));
    }
}
