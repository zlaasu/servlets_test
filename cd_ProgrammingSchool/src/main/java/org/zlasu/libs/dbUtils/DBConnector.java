package org.zlasu.libs.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String DB_URL = "jdbc:mysql://localhost:3306/programmingSchool?useSSL=false&characterEncoding=utf8";
    private static String DB_USER = "root";
    private static String DB_PASS = "root";

    public static Connection getConnection() throws SQLException {
        return DbUtil.getConnection();
        //return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}