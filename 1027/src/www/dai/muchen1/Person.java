package www.dai.muchen1;

public class Person {
        private String name;//实例成员变量
        private int age;
        private String sex;
        private static int count = 0;//静态成员变量 由类共享数据 方法区
        public Person(){
            System.out.println("I am Person init()!");
        }
        //实例代码块
        {
            this.name = "bit";
            this.age = 12;
            this.sex = "man";
            System.out.println("I am instance init()!");
        }
        //静态代码块
        static {
                    count = 10;//只能访问静态数据成员
            System.out.println("I am static init()!");
        }
        public void show(){
            System.out.println("name: "+name+" age: "+age+" sex: "+sex);
        }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

