package by.petrovich.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    private final String USER_NAME = "root";
    private final String PASSWORD = "HzaArk_XnsS";
    private final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final String CONNECTION_URL = "jdbc:mysql://localhost:3306/billgenerator";

    public Connection receiveConnection() {
            try {
                Connection connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
                Class.forName(JDBC_DRIVER_NAME);
                return connection;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


