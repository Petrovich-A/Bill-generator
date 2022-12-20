package by.petrovich.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    private static Connection connection;
    private final String USER_NAME = "root";
    private final String PASSWORD = "HzaArk_XnsS";
    private final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final String CONNECTION_URL = "jdbc:mysql://localhost:3306/billgenerator";

    public Connection receiveConnection() {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER_NAME);
                connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}

