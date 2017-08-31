package com.xgy.mysql;


import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;

public class ConnectionPool {

    private String jdbcDriver = "";
    private String dbUrl = "";
    private String dbUsername = "";
    private String dbPassword = "";
    private String testTable = "";
    private int initialConnections = 10;
    private int incrementalConnections = 5;
    private int maxConnections = 50;
    private Vector connections = null;


    public ConnectionPool(String jdbcDriver, String dbUrl, String dbUsername, String dbPassword) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }

    public int getInitialConnections() {

        return this.initialConnections;
    }


    public void setInitialConnections(int initialConnections) {
        this.initialConnections = initialConnections;
    }


    public int getIncrementalConnections() {

        return this.incrementalConnections;

    }


    public void setIncrementalConnections(int incrementalConnections) {

        this.incrementalConnections = incrementalConnections;

    }


    public int getMaxConnections() {
        return this.maxConnections;
    }


    public void setMaxConnections(int maxConnections) {

        this.maxConnections = maxConnections;

    }


    public String getTestTable() {

        return this.testTable;

    }


    public void setTestTable(String testTable) {
        this.testTable = testTable;
    }


    public synchronized void createPool() throws Exception {


        if (connections != null) {

            return;

        }


        Driver driver = (Driver) (Class.forName(this.jdbcDriver).newInstance());

        DriverManager.registerDriver(driver);


        connections = new Vector();


        createConnections(this.initialConnections);

        System.out.println(" 123 ");

    }


    @SuppressWarnings("unchecked")
    private void createConnections(int numConnections) throws SQLException {


        for (int x = 0; x < numConnections; x++) {


            if (this.maxConnections > 0 && this.connections.size() >= this.maxConnections) {

                break;

            }

            //add a new PooledConnection object to connections vector


            try {

                connections.addElement(new PooledConnection(newConnection()));

            } catch (SQLException e) {

                System.out.println(e.getMessage());

                throw new SQLException();

            }

            System.out.println(" 234 ");

        }
    }


    private Connection newConnection() throws SQLException {


        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);


        if (connections.size() == 0) {

            DatabaseMetaData metaData = conn.getMetaData();

            int driverMaxConnections = metaData.getMaxConnections();


            if (driverMaxConnections > 0 && this.maxConnections > driverMaxConnections) {

                this.maxConnections = driverMaxConnections;

            }
        }
        return conn;

    }


    public synchronized Connection getConnection() throws SQLException {


        if (connections == null) {

            return null;

        }

        Connection conn = getFreeConnection();


        while (conn == null) {


            wait(250);

            conn = getFreeConnection();


        }

        return conn;
    }


    private Connection getFreeConnection() throws SQLException {


        Connection conn = findFreeConnection();

        if (conn == null) {


            createConnections(incrementalConnections);


            conn = findFreeConnection();

            if (conn == null) {


                return null;

            }

        }

        return conn;

    }


    private Connection findFreeConnection() throws SQLException {

        Connection conn = null;

        PooledConnection pConn = null;


        Enumeration enumerate = connections.elements();


        while (enumerate.hasMoreElements()) {

            pConn = (PooledConnection) enumerate.nextElement();

            if (!pConn.isBusy()) {


                conn = pConn.getConnection();

                pConn.setBusy(true);


                if (!testConnection(conn)) {


                    try {

                        conn = newConnection();

                    } catch (SQLException e) {


                        return null;

                    }

                    pConn.setConnection(conn);

                }

                break;

            }

        }

        return conn;

    }


    private boolean testConnection(Connection conn) {

        try {


            if (testTable.equals("")) {


                conn.setAutoCommit(true);

            } else {

                //check if this connection is valid

                Statement stmt = conn.createStatement();

                stmt.execute("select count(*) from " + testTable);

            }

        } catch (SQLException e) {


            closeConnection(conn);

            return false;

        }


        return true;

    }


    public void returnConnection(Connection conn) {


        if (connections == null) {

            System.out.println(" 123 !");

            return;

        }

        PooledConnection pConn = null;

        Enumeration enumerate = connections.elements();


        while (enumerate.hasMoreElements()) {

            pConn = (PooledConnection) enumerate.nextElement();


            if (conn == pConn.getConnection()) {


                pConn.setBusy(false);

                break;

            }

        }

    }


    public synchronized void refreshConnections() throws SQLException {


        if (connections == null) {

            System.out.println("  2222  ");

            return;

        }

        PooledConnection pConn = null;

        Enumeration enumerate = connections.elements();

        while (enumerate.hasMoreElements()) {


            pConn = (PooledConnection) enumerate.nextElement();


            if (pConn.isBusy()) {

                wait(5000);

            }


            closeConnection(pConn.getConnection());

            pConn.setConnection(newConnection());

            pConn.setBusy(false);

        }

    }


    public synchronized void closeConnectionPool() throws SQLException {


        if (connections == null) {

            System.out.println("123");

            return;

        }

        PooledConnection pConn = null;

        Enumeration enumerate = connections.elements();

        while (enumerate.hasMoreElements()) {

            pConn = (PooledConnection) enumerate.nextElement();


            if (pConn.isBusy()) {

                wait(5000);

            }


            closeConnection(pConn.getConnection());


            connections.removeElement(pConn);

        }


        connections = null;

    }


    private void closeConnection(Connection conn) {

        try {

            conn.close();

        } catch (SQLException e) {


        }

    }


    private void wait(int mSeconds) {

        try {

            Thread.sleep(mSeconds);

        } catch (InterruptedException e) {

        }

    }


    class PooledConnection {

        Connection connection = null;
        boolean busy = false;


        public PooledConnection(Connection connection) {

            this.connection = connection;

        }


        public Connection getConnection() {

            return connection;

        }


        public void setConnection(Connection connection) {

            this.connection = connection;

        }


        public boolean isBusy() {

            return busy;

        }


        public void setBusy(boolean busy) {

            this.busy = busy;

        }

    }

}






