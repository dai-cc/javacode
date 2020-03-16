package com.dai;

public class chen {
    public String name;
    public int age;

    public chen(){
        System.out.println("aaa");
    }

    public void eat() {
        System.out.println("吃饭");
    }
}
class chenchen extends chen{
    public String sex;

//    public chenchen(String name, int age, String sex) {
//        super(name, age);
//        this.sex = sex;
//    }

    public void eat(){
        System.out.println("晨晨吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}

class chenchenchen extends chenchen{
    public String hobby;
    public void kick(){
        System.out.println("打豆豆");
    }
}


