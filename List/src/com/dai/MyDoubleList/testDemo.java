package com.dai.MyDoubleList;

public class testDemo {
    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addLast(1);
        doubleList.addLast(2);
        doubleList.addLast(2);
        doubleList.addLast(4);
        doubleList.addLast(5);

        System.out.println(doubleList.contains(9));
        doubleList.display();

        doubleList.removeAllKey(2);
        doubleList.display();
        System.out.println(doubleList.getlength());
//        doubleList.remove(1);
//        doubleList.display();
//        doubleList.remove(3);
//        doubleList.display();
//        doubleList.remove(5);
//        doubleList.display();

        //doubleList.clear();
    }
}

