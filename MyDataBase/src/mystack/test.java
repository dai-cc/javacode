package mystack;

public class test {
    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>();
        System.out.println(ms.empty());
        ms.push(5);
        ms.push(4);
        ms.push(3);
        ms.push(2);
        ms.push(1);
        System.out.println(ms.empty());
        System.out.println(ms.size());
        System.out.println(ms.peek());
        ms.pop();
        System.out.println(ms.size());
        System.out.println(ms.peek());
    }
}
