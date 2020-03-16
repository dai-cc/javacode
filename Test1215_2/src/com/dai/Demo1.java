package com.dai;

import java.util.ArrayList;
import java.util.Random;

//import java.util.Calendar;
class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class Demo1 {
    public  void printArrayList(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if(s.equals("[")){
                list.remove(i);
                list.add(i,"(");
            }
        }
    }
    public static void main(String[] args) {
        Demo1 demo1=new Demo1();
        ArrayList<String> list=new ArrayList<>();
        list.add("代睦尘");
        list.add("魏星星");
        list.add("何媛媛");

        demo1.printArrayList(list);
        System.out.println(list);
    }
    public static void main2(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        Student a=new Student("代睦尘",18);
        Student b=new Student("魏星星",18);
        Student c=new Student("何媛媛",18);
        Student d=new Student("赵贝贝",18);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        for (int i = 0; i < list.size(); i++) {
            Student stu =list.get(i);
            System.out.println("姓名："+stu.getName()+" "+"年龄："+stu.getAge());
            //System.out.println(list.get(i));

        }
    }
    public static void main1(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Random random=new Random();
        for(int i=0;i<6;i++){
            int num=random.nextInt(33)+1;
            list.add(num);
        }
        System.out.println(list);
/*        Calendar c=Calendar.getInstance();
        System.out.println(c);*/
    }
}
