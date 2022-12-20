package by.petrovich.dao;

import by.petrovich.util.PropertyLoader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final PropertyLoader PROPERTY_LOADER = new PropertyLoader();
    private static final String JDBC_DRIVER_NAME = PROPERTY_LOADER.receive("JDBC_DRIVER_NAME");
    private static final String CONNECTION_URL = PROPERTY_LOADER.receive("CONNECTION_URL");
    private static final String USER_NAME = PROPERTY_LOADER.receive("USER_NAME");
    private static final String PASSWORD = PROPERTY_LOADER.receive("PASSWORD");


    public Connection receiveConnection() {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
            Class.forName(JDBC_DRIVER_NAME);
            LOGGER.log(Level.INFO, "Connection established.");
            return connection;
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Connection Failed!", e);
            throw new RuntimeException(e);
        }
    }
}


