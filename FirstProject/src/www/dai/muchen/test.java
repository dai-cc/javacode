package www.dai.muchen;

public class test {
    private String name;
    private int age;
    public  String sex;

    public test(){

    }

    public test(String name){
        this.name=name;
    }
    public test(String name,int age){
        this.name=name;
        this.age=age;
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

    public static void ti(){

    }
    public void tl(){
        System.out.println("hhh");
    }
}
