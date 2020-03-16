package www.dai.chenchen;
import www.dai.muchen.*;

public class test2 {
    public static void main(String[] args) {
        test testone=new test();
        test testtwo=new test("hhh");
        test testthree=new test();

        test testfour=new test("ddd",18);
        System.out.println(testfour.getName()+testfour.getAge());

        System.out.println(testtwo.getName());

        testone.setName("可爱滴睦尘小姐姐");
        testone.setAge(19);
        System.out.println(testone.getName()+testone.getAge());
        System.out.println(testone.getName().length());

        Test1 test1=new Test1();
        test1.tl();
    }
}
