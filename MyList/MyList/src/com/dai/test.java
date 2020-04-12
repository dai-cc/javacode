package com.dai;

public class test {
    public static void main(String[] args) {
        MySinalList mySinalList=new MySinalList();
        mySinalList.addFirst(3);
        mySinalList.addFirst(2);
        mySinalList.addFirst(1);
//        mySinalList.display();
        mySinalList.addLast(4);
//        mySinalList.display();
//        System.out.println(mySinalList.getLength());


        mySinalList.addIndex(2,7);
        mySinalList.display();
        mySinalList.addIndex(0,7);
        mySinalList.display();
        mySinalList.addIndex(5,7);
        mySinalList.display();

//        mySinalList.contains(9);
//        mySinalList.remove(7);
//        mySinalList.display();
//        mySinalList.remove(7);
//        mySinalList.display();
//        mySinalList.remove(7);
//        mySinalList.display();
//        mySinalList.remove(9);

//        mySinalList.removeAllKey(7);
//        mySinalList.display();

        mySinalList.reverseList();

        //mySinalList.display1();


    }
}
