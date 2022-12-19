package by.petrovich.util;

import by.petrovich.model.Bill;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter {
private static final Logger LOGGER = LogManager.getLogger();
    public void writeFile(Bill bill, File file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(bill.toString());
            objectOutputStream.flush();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "File writing failed.", e);
            throw new RuntimeException(e);
        }
    }

}
