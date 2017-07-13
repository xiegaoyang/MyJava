package com.xgy.mysql;


import java.sql.*;

/**
 * Created by root on 16-10-20.
 */

class Person {
    public String name;
    public String sex;
    public int age;
    public String work;
    public String addr;
    public String mobile;

    Person(String name, String sex, int age, String work, String addr, String mobile) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.work = work;
        this.addr = addr;
        this.mobile = mobile;
    }
}

public class MyMysql {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://xgyvm:3306/test";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123";

    private Connection conn = null;
    private Statement stmt = null;

    public static void main(String[] args) {
        //Test();
        MyMysql mysql = new MyMysql();
        if (!mysql.ConnectDB()) {
            System.out.println("ConnectDB failed");
            return;
        }

        try {
            Person person = new Person("余婷", "女", 26, "行政助理", "湖北黄冈", "13912345678");
            if (!mysql.Insert(person)) {
                System.out.println("Insert failed");
                return;
            }

            if (!mysql.Query(person)) {
                System.out.println("Query failed");
                return;
            }

            person.work = "行政经理";
            if (!mysql.Modify(person)) {
                System.out.println("Modify failed");
                return;
            }

            if (!mysql.Delete(person)) {
                System.out.println("Delete failed");
                return;
            }

        } finally {
            if (!mysql.CloseDB()) {
                System.out.println("CloseDB failed");
            }
        }

    }

    public static void Test() {

        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql = "SELECT name, sex, age, work, addr, mobile FROM person";
            System.out.println("开始查询");
            ResultSet rs = stmt.executeQuery(sql);


            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                String work = rs.getString("work");
                String addr = rs.getString("addr");
                String mobile = rs.getString("mobile");

                // 输出数据
                System.out.print("name: " + name + ", " +
                        "sex: " + sex + ", " +
                        "age: " + age + ", " +
                        "work: " + work + ", " +
                        "addr: " + addr + ", " +
                        "mobile:" + mobile + "\n");

            }

            // 完成后关闭
            System.out.println("关闭数据库");
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (null != stmt) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }// 什么都不做

            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public boolean ConnectDB() {
        // 注册 JDBC 驱动
        try {

            Class.forName("com.mysql.jdbc.Driver");

            if (null == conn) {
                // 打开链接
                System.out.println("连接数据库");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                if (null == conn) {
                    System.out.println("DriverManager.getConnection failed");
                    return false;
                }
            }

            if (null == stmt) {
                stmt = conn.createStatement();
                if (null == stmt) {
                    System.out.println("createStatement failed");
                    return false;
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean CloseDB() {
        try {
            if (null != conn && !conn.isClosed()) {
                conn.close();
            }

            if (null != stmt) {
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean CreateTable() {
        return true;
    }

    public boolean DeleteTable() {
        return true;
    }

    public boolean Insert(Person person) {

        //插入之前先判断记录是否存在
        if (Query(person)) {
            System.out.println("record has exist");
            return true;
        }

        System.out.println("插入");
        //String sql = "INSERT INTO person VALUE('刘婷', '女', 26, '大堂经理', '深圳罗湖', '13632717269');";
        String sql = "INSERT INTO person VALUE('" + person.name + "', '" + person.sex + "', " + person.age + ", '" +
                person.work + "', '" + person.addr + "', '" + person.mobile + "');";
        System.out.println("sql = " + sql);
        try {
            int results = stmt.executeUpdate(sql);
            if (-1 == results) {

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean Delete(Person person) {
        System.out.println("删除");
        String sql = "Delete from person where name='" + person.name + "';";
        System.out.println("sql = " + sql);
        try {
            int results = stmt.executeUpdate(sql);
            if (-1 == results) {

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;


    }

    public boolean Modify(Person person) {
        System.out.println("修改");
        String sql = "UPDATE person SET name='" + person.name + "', sex='" + person.sex + "', age=" + person.age +
                " , work='" + person.work + "', addr='" + person.addr + "', mobile='" + person.mobile + "' where name='" + person.name + "';";
        System.out.println("sql = " + sql);
        try {
            int results = stmt.executeUpdate(sql);
            if (-1 == results) {

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    public boolean Query(Person person) {

        System.out.println("查询");
        String sql = "SELECT name, sex, age, work, addr, mobile FROM person where name='" + person.name + "'";
        System.out.println("sql = " + sql);
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            if (!rs.next()) {
                System.out.println("there are no");
                return false;
            }

            do {
                // 通过字段检索
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                String work = rs.getString("work");
                String addr = rs.getString("addr");
                String mobile = rs.getString("mobile");

                // 输出数据
                System.out.print("name: " + name + ", " +
                        "sex: " + sex + ", " +
                        "age: " + age + ", " +
                        "work: " + work + ", " +
                        "addr: " + addr + ", " +
                        "mobile:" + mobile + "\n");
            } while (rs.next());


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


}
