package www.dai.muchen1;

public class Test {
        private String name;//实例成员变量
        private int age;
        private String sex;
        public Test() {
            System.out.println("I am Person init()!");
        }
        //实例代码块
        {
            this.name = "bit";
            this.age = 12;
            this.sex = "man";
            System.out.println("I am instance init()!");
        }
        public void show(){
            System.out.println("name: "+name+" age: "+age+" sex: "+sex);
        }
}
