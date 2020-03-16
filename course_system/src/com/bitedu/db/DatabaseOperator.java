package com.bitedu.db;

import com.bitedu.data.Student;
import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据库操作模块（增删改查）
public class DatabaseOperator {

    private static String URL = "jdbc:mysql://localhost/course_system?useSSL=false&serverTimezone=UTC";
    private static String USER = "root";
    private static String PASSWORD = "";

    public static DataSource getDataSource() {
        //获取数据源
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        //最好不要这样写dataSource.setURL("jdbc:mysql://localhost......."); 将URL设置为一个static的变量
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

    //插入学生表
    public static void insertStudent(Student stu) {
        //获取数据源
        Connection connection = null; //这样写方便后面释放资源
        PreparedStatement pstmt = null;
        //import com.mysql.jdbc.Connection;这个包代表mysql的驱动 我们应该导入的包是
        try {
            /*DataSource dataSource=getDataSource();
             * connection =dataSource.getConnection();
             * 相当于下面一句
             */
            //获取连接
            connection = getDataSource().getConnection();
            String sql = "insert into student values(?,?,?)";
            //connection.prepareStatement(sql); //这条语句进行插入操作 所以应该再给stmt赋一遍值 否则pstmt会为null
            pstmt = connection.prepareStatement(sql);

            System.out.println(pstmt);
            System.out.println(stu);

            pstmt.setInt(1, stu.getSn());
            pstmt.setString(2, stu.getName());
            pstmt.setInt(3, stu.getClassid());



            //执行
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null){
                    pstmt.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //查询学生表
    public static Student selectStudent(int sn)
    {
        //获取数据源
        Connection connection = null; //这样写方便后面释放资源
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = new Student();
        try{
            connection = getDataSource().getConnection();
            String sql ="select * from student where sn = ?";

            pstmt = connection.prepareStatement(sql);
            System.out.println(pstmt);
            pstmt.setInt(1, sn);
            //执行
            rs = pstmt.executeQuery();
            while(rs.next()){
                student.setSn(rs.getInt("sn"));//从结果集中取出sn这个学号对应的学号把他给student的sn
                student.setName(rs.getString("sname"));
                student.setClassid(rs.getInt("clid"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
    //插入班级表
    //查询班级表

    //插入课程表
    //查询课程表

    //插入教师表
    //查询教师表

    //插入take表
    //查询take表

    //插入teach
    //查询teach
}
