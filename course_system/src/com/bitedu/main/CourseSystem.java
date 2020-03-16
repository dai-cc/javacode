package com.bitedu.main;

import com.bitedu.data.Student;
import com.bitedu.db.DatabaseOperator;

public class CourseSystem {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setSn(20190009);
        stu.setName("亚索3");
        stu.setClassid(1);

        DatabaseOperator.insertStudent(stu);

        //Student stu_querey = DatabaseOperator.selectStudent(20190003);
        System.out.println(DatabaseOperator.selectStudent(190104));
    }
}
