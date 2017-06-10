package com.xgy.postgresql;

import java.io.IOException;
import java.sql.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;


/**
 * Created by root on 16-10-20.
 */
public class MyPostgresql {

    private final String IP = "172.16.7.93";
    private final String PORT = "5433";
    private final String DB = "voip_log";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "pqdAD34rASDF";
    private final String DRIVER = "jdbc:postgresql://";

    private Connection c = null;
    private Statement stmt = null;

    public boolean ConnectDB() {
        String url = DRIVER + IP + ":" + PORT + "/" + DB;
        if (null == c) {
            try {
                c = DriverManager.getConnection(url, USERNAME, PASSWORD);
                if (null == c) {
                    System.out.println("DriverManager.getConnection failed");
                    return false;
                }
                if (null == stmt) {
                    stmt = c.createStatement();
                    if (null == stmt) {
                        System.out.println("createStatement failed");
                        return false;
                    }
                }
                System.out.println("Opened database successfully");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + " : " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean CloseDB() {
        try {
            if (!c.isClosed()) {
                c.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
            stmt.executeUpdate(sql);
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

    public boolean Update(Person person) {
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

    public static void main(String args[]) {

        //TestPostgresql();
        MyPostgresql myPostgresql = new MyPostgresql();
        myPostgresql.batchInsert();

//        MyPostgresql postgresql = new MyPostgresql();
//        if (!postgresql.ConnectDB()) {
//            System.out.println("connect db failed");
//            return;
//        }
//
//        System.out.println("postgresql started");
//
//        if (!postgresql.ConnectDB()) {
//            System.out.println("close db failed");
//            return;
//        }
//
//        System.out.println("postgresql stoped");

    }

    public static void TestPostgresql() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://xgyvm:5432/accounts", "postgres", "pqdAD34rASDF");
            if (null == c) {
                System.out.println("DriverManager.getConnection failed");
                return;
            }
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            try {
                if (!c.isClosed()) {
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //public class PgSqlJdbcCopyStreamsExample

    public void batchInsert() {

        String url = DRIVER + IP + ":" + PORT + "/" + DB;
        System.out.println(url);
        Connection con = null;
        CopyManager copyManager = null;
        String fileName = "batchInsert.txt";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            copyManager = new CopyManager((BaseConnection) con);
            FileReader fileReader = new FileReader(fileName);
            copyManager.copyIn("COPY person(name, sex, work) FROM STDIN", fileReader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.err.println("Done.");

    }


}
