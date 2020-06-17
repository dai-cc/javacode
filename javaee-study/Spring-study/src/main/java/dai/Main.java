package dai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applications.xml");
        // 从容器中获取bean对象
        /*Duck duck1 = (Duck) context.getBean("duck1");
        System.out.println(duck1);
        Duck duck1_1 = (Duck) context.getBean("duck1");
        System.out.println(duck1 == duck1_1);//true duck1默认scope是单例

        Duck duck2 = (Duck) context.getBean("duck2");
        System.out.println(duck2);
        Duck duck2_2 = (Duck) context.getBean("duck2");
        System.out.println(duck2 == duck2_2);//false:duck2设置的scope为prototy，代表调用getBean生成新的对象

        DuckShop shop = (DuckShop) context.getBean("duckShop");
        System.out.println(shop);

        Person p1 = (Person)context.getBean(Person.class);
        System.out.println(p1);

        Duck duck3 = (Duck) context.getBean("duck3");
        System.out.println(duck3);*/
    }
}
