package com.dai.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloBit {

    public static void main(String[] args) {
        Connection connection=null;
        Statement stmt=null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取一个连接
            connection=DriverManager.getConnection ("jdbc:mysql://localhost:3306/dai?useSSL=false&serverTimezone=UTC","root","");
            stmt = connection.createStatement();
            stmt.execute("create database dai1");
//            rs = stmt.executeQuery("select * from score");
/*            while (rs.next()){
                System.out.println(rs.getInt("chinese"));
                System.out.println(rs.getInt(2));
            }*/

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
