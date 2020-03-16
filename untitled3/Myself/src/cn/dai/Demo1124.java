package cn.dai;

import java.util.ArrayList;
import java.util.Collection;

public class Demo1124 {
    public static void main(String[] args) {
        Collection<String> coll =new ArrayList<>();
        System.out.println(coll);
        //打印了[] 说明重写了String方法 因为
        /*在打印一个对象p(集合对象)时，可以直接使用System.out.println(p)；在这里，如果没有对该方法进行重写，

那么println()方法内部会自动调用继承到的toString() 方法，所以输出的是该集合对象中存储的各对象的内存地址，

并用"[ ]"包裹，各存储对象之间用"，"分隔.
*/
        coll.add("张三");//将给定对象添加到当前集合中
        coll.add("李四");
        coll.add("王五");
        System.out.println(coll);

        /*
        * remove 吧给定对象删除 存在该元素删除成功返回TRUE
        * 没有给定对象 说明不存在 返回false*/

        coll.remove("张三");
    }
}
