package www.dai.muchen;


//3、实现交换两个变量的值。要求：需要交换实参的值。
    class Num{
        public int num;
    public Num(int num){
        this.num=num;
    }
}
public class c{
    public static void swap(Num num1,Num num2){
        int tmp=num1.num;
        num1.num=num2.num;
        num2.num=tmp;
    }
    public static void main(String[] args) {
        Num num1=new Num(10);
        Num num2=new Num(20);
        System.out.println("交换前的值："+num1.num+" "+num2.num);
        swap(num1,num2);
        System.out.println("交换后的值："+num1.num+" "+num2.num);
    }
}




/*2、设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
class Animal{
    public String type;
    public int age;
    public String name;

    public Animal(String type,int age,String name){
        this.type=type;
        this.age=age;
        this.name=name;
    }

    public void eat(){
        System.out.println(name+"is eating");
    }
    public void sleep(){
        System.out.println(name+"is sleeping");
    }
    public void kickdoudou(){
        System.out.println(name+"is kicking doudou");
    }
}
public class c {
    public static void main(String[] args) {
        Animal animal = new Animal("cat", 1, "大不妞");
        animal.eat();
        animal.sleep();
        animal.kickdoudou();
    }
}*/



/*1、编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
除四种运算.
class Calculator{
    private double num1;
    private double num2;

    public  Calculator(double num1,double num2){
        this.num1=num1;
        this.num2=num2;
    }
    public double add(){
        return this.num1+this.num2;
    }
    public double sub(){
        return this.num1-this.num2;
    }
    public double mul(){
        return this.num1*this.num2;
    }
      public double div(){
        return this.num1/this.num2;
    }
}
public class c{
 public static void main(String[] args) {
        Calculator calculator=new Calculator(10.0,2.5);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.div());
    }
}*/


