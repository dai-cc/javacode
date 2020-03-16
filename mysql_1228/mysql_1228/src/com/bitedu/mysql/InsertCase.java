package com.bitedu.mysql;

import java.sql.*;

public class InsertCase {
    public static void createTable() {
        Connection connection=null;
        Statement statement=null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/dai?useSSL=false&serverTimezone=UTC", "root", "");
            //创建语句对象
            statement = connection.createStatement();
            //执行
            String sql = "create table jdbctable(col1 int,col2 varchar(20))";
            statement.execute(sql);
            //关闭资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(connection!=null){
                    connection.close();
                }
                if (statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void insertIntoTable() {
        Connection connection=null;
        Statement statement=null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/dai?useSSL=false&serverTimezone=UTC", "root", "");
            //创建语句对象
            statement = connection.createStatement();
            //执行
            String sql = "insert into jdbctable(col1,col2) values(10,'hello')";
            statement.execute(sql);
            //关闭资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(connection!=null){
                    connection.close();
                }
                if (statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void select(){
        ResultSet rs=null;
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dai?useSSL=false&serverTimezone=UTC","root","");
            statement=connection.createStatement();
            rs=statement.executeQuery("select * from jdbctable");
            while(rs.next()){
                System.out.println("col1 "+rs.getInt("col1")+"  "+"col2 "+rs.getString("col2"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        //createTable();
        insertIntoTable();
        select();
    }
}
