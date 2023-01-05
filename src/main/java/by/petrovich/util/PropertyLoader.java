package by.petrovich.util;

import by.petrovich.Main;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertyLoader {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String MYSQL_PROPERTY_PATH = "/properties/MySQL-jdbc-config.properties";
    private static final String POSTGRESQL_PROPERTY_PATH = "/properties/PostgreSQL-jdbc-config.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            InputStream inputStream = Optional.ofNullable(Main.class.getResourceAsStream(POSTGRESQL_PROPERTY_PATH))
                    .orElseThrow(FileNotFoundException::new);
            readProperties(inputStream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "File {} does not exist, initialization failed.", POSTGRESQL_PROPERTY_PATH);
            throw new RuntimeException("File does not exist, initialization failed.", e);
        }
    }

    /**
     * Read data from file
     *
     * @param inputStream link to file as a String
     */
    private static void readProperties(InputStream inputStream) {
        try {
            PROPERTIES.load(inputStream);
            LOGGER.log(Level.INFO, "Reading properties file successfully.");
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Reading properties file failed");
            throw new RuntimeException("Reading properties file failed.", e);
        }
    }

    /**
     * @param propertyName name of key in properties file
     * @return received value from properties file
     */
    public String receive(String propertyName) {
        return PROPERTIES.getProperty(propertyName);
    }

}
