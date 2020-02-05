package www;
class A<T> {
    T value;
    public A(T value) {
        value=this.value;
    }
    T get() {
        return value;
    }
}
public class Demo1231 {
    public static void main(String[] args) {
        A<String> a=new A<>("abc");
        System.out.println("a="+a.get());
    }

}
