package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class demo01 {
    public static void main(String[] args) {
        Object[] a = {};
        int[] arr = {};
        LinkedList ll= new LinkedList();
        ArrayList list = new ArrayList();
        list.add("abc");
        list.add(123);
        //使用迭代器遍历list集合
        //获取迭代器
        Iterator it = list.iterator();
        //使用迭代器中的方法hasNext和next遍历集合
        while(it.hasNext()){
            //因为没有使用泛型，所以他取出的元素是Object类型
            Object obj = it.next();
            System.out.println(obj);

            //此时如果想用String类特有的方法，比如说.length()获取字符串长度，不能使用
            //需要使用到多态向下转型
            String s = (String)obj;
            System.out.println(s.length());
        }
    }
}
