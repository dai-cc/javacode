package lesson2;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args) throws Exception {
        //对象的序列化操作
        Person person = new SerializableTest.Person();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(""));
        oos.writeObject(person);
        //对象的反序列化操作
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(""));
        Person person1 = (Person)ois.readObject();
        System.out.println(person1);

        //new SerializableTest().new Person2();

    }
    private static class Person implements Serializable{
        private String name;
        private Integer age;
    }
    //private class Person2{}
}
