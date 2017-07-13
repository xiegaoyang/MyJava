package com.xgy.mysql;

import java.sql.*;

public class MyDB {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // ����������
        String driver = "com.mysql.jdbc.Driver";

        // URLָ��Ҫ���ʵ����ݿ���xgy
        String url = "jdbc:mysql://127.0.0.1:3306/xgy";

        // MySQL����ʱ���û���
        String user = "root";

        // Java����MySQL����ʱ������
        String password = "123";

        try {
            // ������������
            Class.forName(driver);

            // �������ݿ�
            Connection conn = DriverManager.getConnection(url, user, password);

            if (!conn.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            // statement����ִ��SQL���
            Statement statement = conn.createStatement();

            // Ҫִ�е�SQL���
            String sql = "select * from person";

            // �����

            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("ִ�н��������ʾ:");
            System.out.println("-----------------");
            System.out.println(" age" + "\t" + " ����");
            System.out.println("-----------------");
            String name = null;

            while (rs.next()) {
                // ѡ��sname��������
                name = rs.getString("name");
                // ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
                // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
                //name = new String(name.getBytes("ISO-8859-1"), "GB2312");

                // ������
                System.out.println(rs.getString("age") + "\t" + name);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean ConnectDB() {

        return true;
    }

}
