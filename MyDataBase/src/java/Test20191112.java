package java;
/**
 * @Author: will
 * @Date: 2019/11/12
 * @description:
 */

/*
import java.util.ArrayList;
import java.util.List;

class Book
{}

class Person
{}

class MyArrayList
{
    private Object[] array;
    private int size;

    public void add(Object o)
    {
        // 尾插
    }

    public Object get(int index)
    {
        // 此处应该先检测index释放越界

        return array[index];
    }

    // ...
}



public class Test20191112 {
    public static void main(String[] args) {

        MyArrayList persons = new MyArrayList();
        persons.add(new Person());
        persons.add(new Person());

        MyArrayList books = new MyArrayList();
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());

        Person p = (Person)books.get(0);
    }
}
*/


/*
class Book
{}

class Person
{}

// 泛型的MyArrayList类
class MyArrayList<E>
{
    private E[] array;
    private int size;

    void add(E e)
    {
        array[size++] = e;
    }

    E get(int index)
    {
        return array[index];
    }
}

public class Test20191112 {
    public static void main(String[] args) {

        MyArrayList<Book> books = new MyArrayList<Book>();
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());

        // 编译时间类型检测，发现存储的类型不同时，就会发生编译错误
        // books.add(new Person);
    }
}
*/


/*
import java.util.ArrayList;

class Person{};
class Book{};

public class Test20191112 {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();

        System.out.println(persons.getClass());
        System.out.println(books.getClass());
    }
}
*/

/*
import java.util.ArrayList;
import java.util.List;

public class Test20191112 {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("C 语言");
        courses.add("Java SE");
        courses.add("Java Web");
        courses.add("Java EE");

        // 按照添加的顺序进行打印
        System.out.println(courses);

        // 也可以添加重复的元素
        courses.add("C 语言");
        System.out.println(courses);

        // 按照下标进行访问
        System.out.println(courses.get(0));
        courses.set(courses.lastIndexOf("C 语言"), "C++");

        List<String> subCourse = courses.subList(2,4);
        System.out.println(subCourse);
    }
}
*/



public class Test20191112
{
    public static void main(String[] args) {

        System.out.println("hello");
    }
}

