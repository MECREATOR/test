package com.musiceventms.mes.util;

import java.sql.*;

public class JDBCUtil {
//    private static final String PROPERTY_JDBC_URI = "jdbc.uri";
//    private static final String PROPERTY_JDBC_USERNAME = "jdbc.username";
//    private static final String PROPERTY_JDBC_PASSWORD = "jdbc.password";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
//        String url = System.getProperty(PROPERTY_JDBC_URI);
//        String user = System.getProperty(PROPERTY_JDBC_USERNAME);
//        String pw = System.getProperty(PROPERTY_JDBC_PASSWORD);
        String url = "jdbc:postgresql://dpg-cjir130cfp5c73a5p6k0-a.singapore-postgres.render.com:5432/musicevents";
        String user = "dbuser";
        String pw = "eSR5cyX4zzWGw4hMUBZJKtrOUdWu2lSj";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pw);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
