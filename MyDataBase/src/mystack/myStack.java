package mystack;

public class MyStack<E> {
    private E[] array = (E[]) new Object[100];
    //虽然现在支持泛型，但是底层还是用Obj实现的，所以直接用private E[] array = new E[100];会报错，解决方法就是建一个Obj类型的数组，最后强转一下就可以了
    private int size = 0;

    public void push(E e) {
        if (size == 100) {
            return;
        }
        array[size++] = e;
    }

    public E pop() {
        if (empty()) {
            throw new NullPointerException("栈为空");
        }
        E e = array[size - 1];
        size--;
        return e;
    }

    E peek() {
        if (empty()) {
            throw new NullPointerException("栈为空");
        }
        return array[size - 1];
    }

    boolean empty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    int size() {
        return size;
    }
}

