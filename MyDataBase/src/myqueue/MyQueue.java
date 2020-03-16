package myqueue;

//他的底层结构是带头结点的单链表
class Node<E>{
    public Node<E> next;
    public E data;

    public Node(E e){
        next = null;
        data = e;
    }
    public Node(){
        next = null;
    }
}

public class MyQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public MyQueue(){
        front = rear = new Node<E>();
        size = 0;
    }
    public boolean offer(E e){//相当于尾插
        rear.next = new Node<E>(e);
        rear = rear.next;
        size++;
        return true;
    }
    public E poll(){
        if(isEmpty())
            return null;
        E ret= front.next.data;
        front.next = front.next.next;
        size--;
        return ret;
    }
    public E peek(){
        if(isEmpty()) {
            return null;
        }
        return front.next.data;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return 0 == size;
    }
}
