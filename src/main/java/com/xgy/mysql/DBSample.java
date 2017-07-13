package com.xgy.mysql;

import java.sql.Connection;
import java.sql.SQLException;

public class DBSample {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        ConnectionPool connPool = new ConnectionPool("org.postgresql.Driver",
                "jdbc:postgresql://dbURI:5432/DBName", "postgre", "postgre");

        try {
            connPool.createPool();
            Connection conn = connPool.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
